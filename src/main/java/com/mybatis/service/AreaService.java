package com.mybatis.service;

import com.mybatis.entity.Area;

import java.util.List;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
public interface AreaService {
    List<Area> queryAll();
    boolean insert(Area area);
}
