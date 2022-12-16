package com.pofo.appmgmt.global.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false) 
public class ApiResponse<T> {

	// 결과코
	String status;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	T result;
}
