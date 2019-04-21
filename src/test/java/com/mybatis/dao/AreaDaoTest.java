package com.mybatis.dao;

import com.mybatis.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
   @Resource
   private AreaDao areaDao;
    @Test
    public void queryAll() {
       List<Area> list= areaDao.queryAll();
     System.out.println(list.size());
        assertEquals(2,list.size());
    }

    @Test
    public void queryBuyId() {
     Area area=areaDao.queryById(2);
     System.out.println(area.getAreaName());
     assertEquals("东苑",area.getAreaName());
     System.out.println("YES");
    }

    @Test
    public void insertArea() {
     Area area=new Area();
     area.setAreaName("南苑");
     area.setPriority(3);
     area.setCreateTime(new Date());
     area.setLastEditTime(new Date());
     areaDao.insertArea(area);
    }

    @Test
    public void update() {
     Area area=new Area();
     area.setAreaName("jjj苑");
     area.setPriority(4);
     area.setLastEditTime(new Date());
     area.setAreaId(10);
     areaDao.update(area);
    }

    @Test
    public void deleteArea() {
     areaDao.deleteArea(10);
    }
}