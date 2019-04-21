package com.mybatis.dao;

import com.mybatis.entity.Area;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
@Transactional
public interface AreaDao {
    List<Area> queryAll();
    Area queryById(Integer id);
    int insertArea(Area area);
    int update(Area area);
    int deleteArea(Integer id);
}
