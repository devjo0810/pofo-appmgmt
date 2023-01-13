package com.pofo.appmgmt.domain.code.api;

import com.pofo.appmgmt.domain.code.biz.CodeService;
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


        return new ApiResponse<List<CodeGroupResponse>>()
                .setStatus(ResponseType.SUCCESS.code())
                .setResult(service.getCodeGroupList(params));
    }

    /**
     * Save code group api response.
     *
     * @param params the params
     * @return the api response
     */
    @PostMapping
    public ApiResponse saveCodeGroup(@Valid @RequestBody final List<CodeGroupRequest> params) {
        for (CodeGroupRequest request : params) {
            service.saveCodeGroup(request);
        }

        return new ApiResponse().setStatus(ResponseType.SUCCESS.code());
    }

}
