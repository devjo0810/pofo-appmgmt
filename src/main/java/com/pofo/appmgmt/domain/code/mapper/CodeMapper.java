package com.pofo.appmgmt.domain.code.mapper;

import com.pofo.appmgmt.domain.code.dto.CodeDetailRequest;
import com.pofo.appmgmt.domain.code.dto.CodeDetailResponse;
import com.pofo.appmgmt.domain.code.dto.CodeGroupRequest;
import com.pofo.appmgmt.domain.code.dto.CodeGroupResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CodeMapper {
    List<CodeGroupResponse> getCodeGroupList(Map<String, Object> params);
    void saveCodeGroup(CodeGroupRequest params);

    List<CodeDetailResponse> getCodeDetailList(Map<String, Object> params);

    void saveCodeDetail(CodeDetailRequest params);

    void updateCodeDetail(CodeDetailRequest params);
}
