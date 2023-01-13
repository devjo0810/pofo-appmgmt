package com.pofo.appmgmt.domain.code.biz;

import com.pofo.appmgmt.domain.code.dto.CodeGroupRequest;
import com.pofo.appmgmt.domain.code.dto.CodeGroupResponse;
import com.pofo.appmgmt.domain.code.mapper.CodeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeMapper mapper;

    public List<CodeGroupResponse> getCodeGroupList(Map<String, Object> params) {
        return mapper.getCodeGroupList(params);
    }

    public void saveCodeGroup(CodeGroupRequest params) {
        mapper.saveCodeGroup(params);
    }

}
