package com.jk.controller;

import com.jk.client.LoginClient;
import com.jk.pojo.User;
import com.jk.util.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class LoginController {
    @Autowired
    LoginClient loginClient;
    @RequestMapping("toLogin")
    public String toLogin(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
        if(Contant.remPwd.equals(cookie.getName())) {
        String[] s = cookie.getValue().split("#");
            model.addAttribute("account",s[0]);
            model.addAttribute("userPwd",s[1]);
        }
//            String decode = URLDecoder.decode(cookie.getValue(), "utf-8");
//            User user = JSONObject.parseObject(decode, User.class);
//            model.addAttribute("account", user.getAccount());
//            model.addAttribute("userPwd", user.getUserPwd());
//        }
        }
        return "login";
    }
    @ResponseBody
    @RequestMapping("login")
    public String loginTest(User user, HttpSession session, HttpServletResponse response) throws UnsupportedEncodingException {
        User userFromDB = loginClient.invokeLogin(user);
        if(userFromDB==null){
            return "0";
        }else{
            session.setAttribute("user",userFromDB);
            if(user.getRemPwd()!=null){
                Cookie cookie = new Cookie(Contant.remPwd,user.getAccount()+Contant.separator+user.getUserPwd());
                cookie.setMaxAge(604800);
                cookie.setPath("/");
                response.addCookie(cookie);
//                String pwd = JSONObject.toJSONString(userFromDB);
//                String encode = URLEncoder.encode(pwd, "utf-8");
//                Cookie cookie = new Cookie(Contant.remPwd, encode);
//                cookie.setMaxAge(604800);
//                cookie.setPath("/");
//                response.addCookie(cookie);
            }else{
                Cookie cookie = new Cookie(Contant.remPwd,null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return "1";
    }
    @RequestMapping("toView")
    public String toView(String view){
        return view;
    }
}
