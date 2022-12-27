package com.pofo.appmgmt.domain.code.api;

import com.pofo.appmgmt.domain.code.biz.CodeService;
import com.pofo.appmgmt.domain.code.dto.CodeGroupRequest;
import com.pofo.appmgmt.global.dto.ApiResponse;
import com.pofo.appmgmt.global.type.ResponseType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/appmgmt/codes")
@RequiredArgsConstructor
public class CodeApi {

    private final CodeService service;

    /**
     * Save code group api response.
     *
     * @param params the params
     * @return the api response
     */
    @PostMapping
    public ApiResponse saveCodeGroup(@Valid @RequestBody final CodeGroupRequest params) {
        service.saveCodeGroup(params);

        return new ApiResponse().setStatus(ResponseType.SUCCESS.code());
    }

    @GetMapping("/{cmmCdGrpId}")
    public ApiResponse<String> getCmmCdGrpId(@PathVariable("cmmCdGrpId") String cmmCdGrpId) {
        return new ApiResponse().setStatus(ResponseType.SUCCESS.code()).setResult(cmmCdGrpId);
    }
}
