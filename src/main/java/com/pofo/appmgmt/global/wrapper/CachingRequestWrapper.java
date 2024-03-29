package com.pofo.appmgmt.global.wrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class CachingRequestWrapper extends HttpServletRequestWrapper {

	private final Charset encoding;
	private byte[] rawData;
	private Map<String, String[]> parameterMap;
	
	public CachingRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		
		String characterEncoding = request.getCharacterEncoding();
		if (StringUtils.isEmpty(characterEncoding)) {
			characterEncoding = StandardCharsets.UTF_8.name();
		}
		
		this.encoding = Charset.forName(characterEncoding);
		
		parameterMap = request.getParameterMap();
		try (InputStream inputStream = request.getInputStream()) {
			this.rawData = IOUtils.toByteArray(inputStream);
		}
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return this.parameterMap;
	}

	@Override
	public ServletInputStream getInputStream() {
		return new CachedServletInputStream(this.rawData);
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(this.getInputStream(), this.encoding));
	}
	
	private static class CachedServletInputStream extends ServletInputStream {
		
		private final ByteArrayInputStream buffer;
		
		public CachedServletInputStream(byte[] contents) {
			this.buffer = new ByteArrayInputStream(contents);
		}

		@Override
		public boolean isFinished() {
			return this.buffer.available() == 0;
		}

		@Override
		public boolean isReady() {
			return true;
		}

		@Override
		public void setReadListener(ReadListener listener) {
			throw new UnsupportedOperationException("not support");
		}

		@Override
		public int read() throws IOException {
			return this.buffer.read();
		}
		
	}

}
