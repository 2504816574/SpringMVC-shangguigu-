package com.test;


import com.bean.Employee;
import com.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;


@Controller
public class TestJsonController {

    @Autowired
    private EmployeeDao dao;

    /**
     * springMVC处理json的四个条件：
     * 1、导入jackson的jar
     * 2、在springMVC的配置文件中开启MVC驱动，<mvc:annotation-driven />
     * 3、在处理ajax请求的方法上加上注解@ResponseBody
     * 4、将要转换为json且响应到客户端的数据，直接作为该方法的返回值返回
     *
     * @return
     * @ResponseBody
     */
    @RequestMapping("/testJson")
    @ResponseBody
    public Collection<Employee> testJson() {
        return dao.getAll();
    }

}
