package com.pofo.appmgmt.global.dto;

import lombok.Data;
import lombok.ToString;

/**
 * packageName    : com.pofo.appmgmt.global.dto
 * fileName       : ErrorResponse
 * author         : joyousang
 * date           : 2023/02/16
 * description    :
 */
@Data
@ToString
public class ErrorResponse {
    private String code;
    private String message;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
