package com.pofo.appmgmt.domain.menu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * packageName    : com.pofo.appmgmt.domain.menu.dto
 * fileName       : MenuResponse
 * author         : joyousang
 * date           : 2023/02/14
 * description    :
 */
@Getter
@Setter
public class MenuResponse {
    private Long sersNum;
    private String menuId;
    private String hrnkMenuId;
    private String menuStep;
    private String menuNm;
    private String wdgtMenuNm;
    private int sortSqnc;
    private String menuDvsn;
    private String menuYn;
    private String useYn;
    private long rgsrNum;
    private String regDt;
    private long upsrNum;
    private String updtDt;
    @JsonProperty("_children")
    private List<MenuResponse> children;
}
