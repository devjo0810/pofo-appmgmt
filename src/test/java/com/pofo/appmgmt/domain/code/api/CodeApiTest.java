package com.pofo.appmgmt.domain.code.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("코드 API TEST")
@WebMvcTest(CodeApi.class)
@SpringBootTest
class CodeApiTest {

    private final String BASE_URL = "/codes";
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("[API]공통 코드 그룹 등록")
    public void saveCodeGroupSuccessCase() throws Exception{

//        CodeGroupRequest body = CodeGroupRequest.builder()
//                .cmmCdGrpId("testCdGrpId")
//                .cmmCdGrpNm("testCdGrpNm")
//                .cmmCdGrpDsc("testCdGrpDsc")
//                .useYn(true)
//                .build();
//
//        mockMvc.perform(
//                post(BASE_URL)
//                .content(mapper.writeValueAsString(body))
//                .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk());
    }

    @Test
    @DisplayName("[API]공통 코드 그룹 조회")
    public void getCodeGroupIdSuccessCase() throws Exception {
        mockMvc.perform(get(BASE_URL + "/213"))
                .andExpect(status().isOk());
    }
}