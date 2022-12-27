package com.pofo.appmgmt.domain.code.biz;

import com.pofo.appmgmt.domain.code.dto.CodeGroupRequest;
import com.pofo.appmgmt.domain.code.mapper.CodeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeMapper mapper;

    public void saveCodeGroup(CodeGroupRequest params) {
        mapper.saveCodeGroup(params);
    }
}
