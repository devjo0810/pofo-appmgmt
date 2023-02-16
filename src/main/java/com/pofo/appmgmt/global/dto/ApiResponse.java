package com.pofo.appmgmt.global.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false) 
public class ApiResponse<T> {

	// 결과코
	private String code;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T data;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ErrorResponse error;

	public ApiResponse(String code) {
		this.code = code;
	}

	public ApiResponse(String code, T data) {
		this.code = code;
		this.data = data;
	}

	public ApiResponse(String code, ErrorResponse error) {
		this.code = code;
		this.error = error;
	}
}
