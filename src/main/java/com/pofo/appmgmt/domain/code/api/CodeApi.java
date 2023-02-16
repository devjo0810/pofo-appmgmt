package com.pofo.appmgmt.domain.code.api;

import com.pofo.appmgmt.domain.code.biz.CodeService;
import com.pofo.appmgmt.domain.code.dto.CodeDetailRequest;
import com.pofo.appmgmt.domain.code.dto.CodeDetailResponse;
import com.pofo.appmgmt.domain.code.dto.CodeGroupRequest;
import com.pofo.appmgmt.domain.code.dto.CodeGroupResponse;
import com.pofo.appmgmt.global.dto.ApiResponse;
import com.pofo.appmgmt.global.type.ResponseType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appmgmt/codes")
@RequiredArgsConstructor
public class CodeApi {

    private final CodeService service;

    @GetMapping
    public ApiResponse<List<CodeGroupResponse>> getCodeGroupList(@RequestParam Map<String, Object> params) {

        return new ApiResponse<>(ResponseType.SUCCESS.code(), service.getCodeGroupList(params));
    }

    /**
     * Save code group api response.
     *
     * @param params the params
     * @return the api response
     */
    @PostMapping
    public ApiResponse saveCodeGroup(@Valid @RequestBody final List<CodeGroupRequest> params) {
        params.forEach(item -> service.saveCodeGroup(item));

        return new ApiResponse(ResponseType.SUCCESS.code());
    }

    @GetMapping("/detail")
    public ApiResponse<List<CodeDetailResponse>> getCodeDetailList(@RequestParam Map<String, Object> params) {
        return new ApiResponse<>(ResponseType.SUCCESS.code(), service.getCodeDetailList(params));
    }

    @PostMapping("/detail")
    public ApiResponse saveCodeDetail(@Valid @RequestBody final List<CodeDetailRequest> params) {
        params.forEach(item -> service.saveCodeDetail(item));

        return new ApiResponse(ResponseType.SUCCESS.code());
    }
}
