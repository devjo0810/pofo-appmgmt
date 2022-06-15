package com.pofo.appmgmt.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pofo.appmgmt.common.model.ApiResponseModel;
import com.pofo.appmgmt.common.type.ResponseType;

import lombok.Data;
import lombok.ToString;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@Data
	@ToString
	public static class ErrorResponse {
		String code;
		String message;
		
		public ErrorResponse(String code, String message) {
			this.code = code;
			this.message = message;
		}
	}
	
	@ExceptionHandler(value = {Exception.class, RuntimeException.class})
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ApiResponseModel<ErrorResponse> handleException(
			HttpServletRequest request,
			HttpServletResponse response,
			Exception e) {
		
		logger.error(e.getMessage(), e);
		
		ResponseType apiResponseType = null;
		String apiResponseMessage = "";
		
		// 로그인 Exception
		if (e instanceof NotLoginException) {
			apiResponseType = ResponseType.NOT_LOGIN;
			apiResponseMessage = "로그인 정보가 없습니다.";
			
		// 권한 Exception
		} else if (e instanceof UnauthorizationException) {
			apiResponseType = ResponseType.UNAUTHORIZATION;
			apiResponseMessage = "권한이 없습니다.";
			
		// 파일 업로드 Exception
		} else if (e instanceof FileUploadException) {
			apiResponseType = ResponseType.FILE_UPLOAD_FAIL;
			apiResponseMessage = "파일 업로드중 오류가 발생했습니다.";
			
		// 파일 다운로드 Exception
		} else if (e instanceof FileDownloadException) {
			apiResponseType = ResponseType.FILE_DOWNLOAD_FAIL;
			apiResponseMessage = "파일 다운로드중 오류가 발생했습니다.";
			
		// Valid Exception
		} else if (e instanceof ValidationException) {
			apiResponseType = ResponseType.NOT_VALID_AGUMANT;
			apiResponseMessage = e.getMessage();
			
		} else {
			apiResponseType = ResponseType.ERROR;
			apiResponseMessage = e.getMessage();
		}
		
		ErrorResponse errorResponse = new ErrorResponse(apiResponseType.code(), apiResponseMessage);
		
		ApiResponseModel<ErrorResponse> apiResponse = new ApiResponseModel<ErrorResponse>()
				.setStatus(apiResponseType.code())
				.setResult(errorResponse);
		
		return apiResponse;
	}
	
}
