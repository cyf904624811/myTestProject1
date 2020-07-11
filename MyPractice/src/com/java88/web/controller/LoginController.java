package com.java88.web.controller;

import com.java88.domain.User;
import com.java88.util.CheckCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {


    @RequestMapping("res1")
    public String login1(@Valid User user, BindingResult result, Model model)
    {
//        System.out.println(user);
        List<FieldError> fieldErrors = result.getFieldErrors();
        for (FieldError error:fieldErrors
             ) {
            System.out.println(error.getField()+":"+error.getDefaultMessage());
        }


        user.setMoney(995);
        //下面这条语句自动执行
        String[] strings = {"篮球","足球"};
        user.setHobby(strings);
        model.addAttribute(user);



        return "/login/loginimpl2.jsp";
    }

    @RequestMapping("/checkCode")
    @ResponseBody
    public void checkCode(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {

        CheckCodeUtil.outputCaptcha(request,response);
        String s = (String) request.getSession().getAttribute("randomString");
        System.out.println(s);

    }


}
