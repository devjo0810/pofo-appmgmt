package com.pofo.appmgmt.domain.code.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * packageName    : com.pofo.appmgmt.domain.code.dto
 * fileName       : CodeDetailResponse
 * author         : joyousang
 * date           : 2023/01/18
 * description    :
 */
@Getter
@Setter
public class CodeDetailResponse {
    private long sersNum;
    private String cmmCdGrpId;
    private String cmmCd;
    private String cmmCdNm;
    private String cmmCdDsc;
    private int sortSqnc;
    private String refrId1;
    private String refrId2;
    private String refrId3;
    private String refrId4;
    private String useYn;
    private String rgsrNm;
    private String regDt;
    private String upsrNm;
    private String updtDt;
}
