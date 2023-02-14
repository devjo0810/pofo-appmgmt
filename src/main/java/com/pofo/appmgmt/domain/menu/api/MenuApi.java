package com.pofo.appmgmt.domain.menu.api;

import com.pofo.appmgmt.domain.menu.biz.MenuService;
import com.pofo.appmgmt.domain.menu.dto.MenuRequest;
import com.pofo.appmgmt.domain.menu.dto.MenuResponse;
import com.pofo.appmgmt.global.dto.ApiResponse;
import com.pofo.appmgmt.global.type.ResponseType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/appmgmt/menus")
@RequiredArgsConstructor
public class MenuApi {

    private final MenuService menuService;

    @GetMapping
    public ApiResponse<List<MenuResponse>> findMenus() {
        List<MenuResponse> result = menuService.findMenus();

        return new ApiResponse<List<MenuResponse>>().setStatus(ResponseType.SUCCESS.code()).setResult(result);
    }

    @PostMapping
    public ApiResponse saveMenus(@Valid @RequestBody final List<MenuRequest> params) {
        params.forEach(item -> menuService.saveMenu(item));

        return new ApiResponse().setStatus(ResponseType.SUCCESS.code());
    }
}
