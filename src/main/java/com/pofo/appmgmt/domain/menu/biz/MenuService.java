package com.pofo.appmgmt.domain.menu.biz;

import com.pofo.appmgmt.domain.menu.dto.MenuRequest;
import com.pofo.appmgmt.domain.menu.dto.MenuResponse;
import com.pofo.appmgmt.domain.menu.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName    : com.pofo.appmgmt.domain.menu.biz
 * fileName       : MenuService
 * author         : joyousang
 * date           : 2023/02/14
 * description    :
 */
@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuMapper mapper;
    public int saveMenu(MenuRequest item) {
        return mapper.saveMenu(item);
    }

    public List<MenuResponse> findMenus() {
        List<MenuResponse> menus = this.findMenusByMenuId("0");
        menus.forEach(item -> this.recursiveFindMenus(item));
        return menus;
    }

    public void recursiveFindMenus(MenuResponse menu) {
        if (menu == null) return;
        List<MenuResponse> menus = this.findMenusByMenuId(menu.getMenuId());
        if (menus == null || menus.isEmpty()) {
            menu.setChildren(null);
        } else {
            menu.setChildren(menus);
            menus.forEach(item -> this.recursiveFindMenus(item));
        }
    }

    public List<MenuResponse> findMenusByMap(Map<String, Object> params) {
        List<MenuResponse> menus = mapper.findMenusByMap(params);
        menus.forEach(item -> this.recursiveFindMenusByMap(item));
        return menus;
    }

    public void recursiveFindMenusByMap(MenuResponse menu) {
        if (menu == null) return;
        List<MenuResponse> menus = mapper.findMenusByMap(new HashMap<>(){{
            put("menuId", menu.getMenuId());
            put("menuDvsn", menu.getMenuDvsn());
        }});
        if (menus == null || menus.isEmpty()) {
            menu.setChildren(null);
        } else {
            menu.setChildren(menus);
            menus.forEach(item -> this.recursiveFindMenusByMap(item));
        }
    }

    public List<MenuResponse> findMenusByMenuId(String menuId) {
        return mapper.findMenusByMenuId(menuId);
    }
}
