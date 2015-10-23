package com.doomphantoom.controller;

import com.doomphantoom.util.JsonUtil;
import com.doomphantoom.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by doomphantom on 23/10/2015.
 */
@Controller
@RequestMapping("/validation")
public class ValidatorController {

    @RequestMapping("/userSignUp")
    @ResponseBody
    public String userSignUp(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            String errorInfoInJson = JsonUtil.convertObjectToJson(errors);
            return errorInfoInJson;
        }
        return "{'status':'ok'}";
    }

    @RequestMapping("/adminSignUp")
    @ResponseBody
    public String adminSignUp(@Validated @RequestBody User admin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            String errorInfoInJson = JsonUtil.convertObjectToJson(errors);
            return errorInfoInJson;
        }
        return "{'status':'ok'}";
    }
}
