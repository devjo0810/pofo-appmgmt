package com.pofo.appmgmt.domain.code.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * packageName    : com.pofo.appmgmt.domain.code.dto
 * fileName       : CodeDetailRequest
 * author         : joyousang
 * date           : 2023/01/18
 * description    :
 */
@Getter
@Setter
public class CodeDetailRequest {
    private Long sersNum;
    @NotBlank(message = "공통코드그룹아이디는 필수값입니다.")
    private String cmmCdGrpId;
    @NotBlank(message = "공통코드는 필수값입니다.")
    private String cmmCd;
    @NotBlank(message = "공통코드명은 필수값입니다.")
    private String cmmCdNm;
    private String cmmCdDsc;
    private int sortSqnc;
    private String refrId1;
    private String refrId2;
    private String refrId3;
    private String refrId4;
    private boolean useYn;
    private long rgsrNum;
    private long upsrNum;
}
