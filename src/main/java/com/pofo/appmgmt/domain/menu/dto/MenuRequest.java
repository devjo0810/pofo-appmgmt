package com.pofo.appmgmt.domain.menu.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * packageName    : com.pofo.appmgmt.domain.menu.dto
 * fileName       : MenuRequest
 * author         : joyousang
 * date           : 2023/02/14
 * description    :
 */
@Getter
@Setter
public class MenuRequest {
    @NotBlank(message = "메뉴아이디는 필수값입니다.")
    private String menuId;
    @NotBlank(message = "상위메뉴아이디는 필수값입니다.")
    private String hrnkMenuId;
    private String menuStep;
    private String menuNm;
    private String wdgtMenuNm;
    private int sortSqnc;
    private String menuDvsn;
    private boolean menuYn;
    private boolean useYn;
    private long rgsrNum;
    private long upsrNum;
}
