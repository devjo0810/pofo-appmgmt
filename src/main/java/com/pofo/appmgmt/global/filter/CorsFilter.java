package com.pofo.appmgmt.global.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.pofo.appmgmt.global.type.HeaderType;
import com.pofo.appmgmt.global.wrapper.CachingRequestWrapper;
import com.pofo.appmgmt.global.wrapper.CachingResponseWrapper;

public class CorsFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String applicationPath = request.getRequestURI();
		
		if (applicationPath.indexOf("/websocket") >= 0) {
			// pass
		} else {
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			response.addHeader("Access-Control-Allow-Headers", "Accept, Content-Type, Pragma, Expires, Cache-Control, " + HeaderType.JWT.code());
			response.addHeader("Access-Control-Expose-Headers", HeaderType.JWT.code());
		}
		
		if (!(applicationPath.indexOf("/common/file/upload") > 0 || applicationPath.indexOf("/common/file/download") > 0)) {
			if (isAsyncDispatch(request)) {
				filterChain.doFilter(request, response);
			} else {
				filterChain.doFilter(new CachingRequestWrapper(request), new CachingResponseWrapper(response));
			}
		} else {
			filterChain.doFilter(request, response);
		}
		
	}

	
}
