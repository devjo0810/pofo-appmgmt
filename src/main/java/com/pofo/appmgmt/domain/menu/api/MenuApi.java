package com.pofo.appmgmt.domain.menu.api;

import com.pofo.appmgmt.domain.menu.biz.MenuService;
import com.pofo.appmgmt.domain.menu.dto.MenuRequest;
import com.pofo.appmgmt.domain.menu.dto.MenuResponse;
import com.pofo.appmgmt.global.dto.ApiResponse;
import com.pofo.appmgmt.global.type.ResponseType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appmgmt/menus")
@RequiredArgsConstructor
public class MenuApi {

    private final MenuService menuService;

    @GetMapping
    public ApiResponse<List<MenuResponse>> findMenus() {
        List<MenuResponse> result = menuService.findMenus();

        return new ApiResponse<>(ResponseType.SUCCESS.code(), result);
    }

    @GetMapping("/{menu_dvsn}")
    public ApiResponse<List<MenuResponse>> findMenusByMenuDvsn(@PathVariable("menu_dvsn") String menuDvsn) {
        Map<String, Object> params = new HashMap<>();
        params.put("menuDvsn", menuDvsn);
        params.put("menuId", "0");
        List<MenuResponse> menus = menuService.findMenusByMap(params);

        return new ApiResponse(ResponseType.SUCCESS.code(), menus);
    }

    @PostMapping
    public ApiResponse saveMenus(@Valid @RequestBody final List<MenuRequest> params) {
        params.forEach(item -> menuService.saveMenu(item));

        return new ApiResponse(ResponseType.SUCCESS.code());
    }
}
