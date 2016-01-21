package com.doomphantoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Trung on 12/21/2015.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "admin";
    }

}
