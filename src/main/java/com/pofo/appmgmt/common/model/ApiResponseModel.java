package com.pofo.appmgmt.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
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
public class ApiResponseModel<T> {

	// 결과코
	String status;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	T result;
}
