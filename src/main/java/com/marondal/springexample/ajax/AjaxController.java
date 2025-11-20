package com.marondal.springexample.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/ajax")
@Controller
public class AjaxController {

    // response에 데이터(JSON)를 담는 페이지
    // API <---> View(HTML)
    // 이름과 생년월일을 전달 받고, 이름과 나이를 JSON으로 응답에 담는다
    @ResponseBody
    @GetMapping("/person")
    public Map<String, Object> personInfo(
            @RequestParam("name") String name
            , @RequestParam("birthday") String birthday) {  // 20030523

        int year = Integer.parseInt(birthday.substring(0, 4));
        int age = 2025 - year + 1;

        // {"name":"유재석", "age":28}

        Map<String, Object> personMap = new HashMap<>();

        personMap.put("name", name);
        personMap.put("age", age);

        return personMap;

    }


    @GetMapping("/ex01")
    public String ex01() {
        return "ajax/ex01";
    }
}
