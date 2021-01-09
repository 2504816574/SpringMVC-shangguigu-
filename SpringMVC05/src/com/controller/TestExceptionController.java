package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestExceptionController {

    @RequestMapping(value = "/testException", method = RequestMethod.GET)
    public String testException() {
        String s = null;
        String substring = s.substring(0, 10);
        System.out.println(substring);
        return "success";
    }

}
