package com.pofo.appmgmt.global.wrapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.io.output.TeeOutputStream;
import org.springframework.util.FastByteArrayOutputStream;

public class CachingResponseWrapper extends HttpServletResponseWrapper {

	private final FastByteArrayOutputStream content = new FastByteArrayOutputStream(1024);
	private ServletOutputStream outputStream;
	private PrintWriter writer;
	
	public CachingResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (this.outputStream == null) {
			this.outputStream = new CachedServletOutputStream(getResponse().getOutputStream(), this.content);
		}
		return this.outputStream;
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		if (this.writer == null) {
			this.writer = new PrintWriter(new OutputStreamWriter(content, this.getCharacterEncoding()), true);
		}
		return this.writer;
	}

	public InputStream getContentInputStream() {
		return this.content.getInputStream();
	}

	private class CachedServletOutputStream extends ServletOutputStream {
		
		private final TeeOutputStream targetStream;
		
		public CachedServletOutputStream(OutputStream one, OutputStream two) {
			targetStream = new TeeOutputStream(one, two);
		}

		@Override
		public boolean isReady() {
			return false;
		}

		@Override
		public void setWriteListener(WriteListener listener) {
			throw new UnsupportedOperationException("not support");
		}

		@Override
		public void write(int b) throws IOException {
			this.targetStream.write(b);
		}

		@Override
		public void write(byte[] b, int off, int len) throws IOException {
			this.targetStream.write(b, off, len);
		}

		@Override
		public void flush() throws IOException {
			super.flush();
			this.targetStream.flush();
		}

		@Override
		public void close() throws IOException {
			super.close();
			this.targetStream.close();
		}
		
	}
	
}
