package com.mybatis.service;

import com.mybatis.dao.AreaDao;
import com.mybatis.entity.Area;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Resource
    private AreaDao areaDao;
    @Transactional
    @Override
    public List<Area> queryAll() {
        Area area=new Area();
        area.setAreaName("333名字");
        area.setPriority(7);
        area.setCreateTime(new Date());
        areaDao.insertArea(area);
//        if(area!=null){
//            throw new RuntimeException("出书异常");
//        }
        //int a=1/0;
        return areaDao.queryAll();
    }
    @Transactional
    @Override
    public boolean insert(Area area) {
          if(area.getAreaName()!=null&&!"".equals(area.getAreaName())){
              area.setCreateTime(new Date());
              area.setLastEditTime(new Date());
              try{
                int effectNum= areaDao.insertArea(area);
                if(effectNum>0){
                    return true;
                }else {
                    throw new RuntimeException("插入失败");
                }
              }catch (Exception e){
                  throw new RuntimeException("插入失败"+e.getMessage());
              }
          }else {
              throw new RuntimeException("区域名称不能为空！");
          }
    }
}
