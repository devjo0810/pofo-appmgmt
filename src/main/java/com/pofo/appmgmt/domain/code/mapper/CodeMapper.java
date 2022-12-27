package com.pofo.appmgmt.domain.code.mapper;

import com.pofo.appmgmt.domain.code.dto.CodeGroupRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeMapper {
    void saveCodeGroup(CodeGroupRequest params);
}
