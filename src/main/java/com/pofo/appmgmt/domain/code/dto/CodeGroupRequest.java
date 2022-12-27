package com.pofo.appmgmt.domain.code.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CodeGroupRequest {

    @NotBlank(message = "공통코드그룹아이디는 필수값입니다.")
    private String cmmCdGrpId;

    @NotBlank(message = "공통코드그룹명은 필수값입니다.")
    private String cmmCdGrpNm;

    private String cmmCdGrpDsc;

    private boolean useYn;

}
