package com.pofo.appmgmt.domain.code.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * packageName    : com.pofo.appmgmt.domain.code.dto
 * fileName       : CodeGroupResponse
 * author         : joyousang
 * date           : 2023/01/13
 * description    :
 */
@Getter
@Setter
public class CodeGroupResponse {
    private String cmmCdGrpId;
    private String cmmCdGrpNm;
    private String cmmCdGrpDsc;
    private String useYn;
    private String rgsrNm;
    private String regDt;
    private String upsrNm;
    private String updtDt;
}
