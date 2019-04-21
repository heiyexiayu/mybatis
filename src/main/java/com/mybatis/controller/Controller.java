package com.mybatis.controller;

import com.mybatis.entity.Area;
import com.mybatis.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */

@RestController
@RequestMapping(value = "/mybatis")
public class Controller {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    private Map<String,Object> list(){
        Map<String,Object> modelMap=new HashMap<>();
        List<Area> list=areaService.queryAll();
        modelMap.put("list",list);
        return modelMap;
    }
}
