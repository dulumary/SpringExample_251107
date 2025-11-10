package com.marondal.springexample.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex02Controller {

    // html 경로를 통해 html 을 응답에 담는 경우 ResponseBody 없음
    @RequestMapping("/lifecycle/ex02")
    public String thymeleaf() {
        // html 파일 경로
        // src/main/resources/templates 생략
        // .html 생략
        return "lifecycle/ex02";
    }
}
