package com.marondal.springexample.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/thymeleaf")
@Controller
public class ThymeleafController {

    @GetMapping("/ex01")
    public String ex01() {
        return "thymeleaf/ex01";
    }

    @GetMapping("/ex02")
    public String ex02(Model model) {

        // 과일 이름 리스트
        List<String> fruitList = new ArrayList<>();

        fruitList.add("사과");
        fruitList.add("귤");
        fruitList.add("바나나");

        model.addAttribute("fruitList", fruitList);


        // 사용자 정보 리스트 
        // 이름, 나이, 취미
        // {"name":"김인규", "age":28, "hobby":"독서"}

        List<Map<String, Object>> userList = new ArrayList<>();

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "김인규");
        userMap.put("age", 28);
        userMap.put("hobby", "독서");

        userList.add(userMap);

        userMap = new HashMap();
        userMap.put("name", "바다");
        userMap.put("age", 7);
        userMap.put("hobby", "사냥하기");
        userList.add(userMap);



        model.addAttribute("userList", userList);



        return "thymeleaf/ex02";
    }
}
