package com.pofo.appmgmt.domain.menu.mapper;

import com.pofo.appmgmt.domain.menu.dto.MenuRequest;
import com.pofo.appmgmt.domain.menu.dto.MenuResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.pofo.appmgmt.domain.menu
 * fileName       : MenuMapper
 * author         : joyousang
 * date           : 2023/02/14
 * description    :
 */
@Mapper
public interface MenuMapper {
    int saveMenu(MenuRequest params);

    List<MenuResponse> findMenusByMenuId(String menuId);

    List<MenuResponse> findMenusByMap(Map<String, Object> params);
}
