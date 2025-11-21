package com.marondal.springexample.ajax;

import com.marondal.springexample.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/ajax/user")
@Controller
public class NewUserController {
    @Autowired
    private UserService userService;

    // 사용자 정보를 전달 받고 저장하는 API
    @ResponseBody
    @PostMapping("/add")
    public Map<String, String> addUser(
            @RequestParam("name") String name
            , @RequestParam("birthday") String birthday
            , @RequestParam("email") String email
            , @RequestParam("introduce") String introduce) {

        int count = userService.createUser(name, birthday, email, introduce);

        // 성공 {"result":"success"}
        // 실패 {"result":"fail"}
        Map<String, String> resultMap = new HashMap<>();

        if(count == 1) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }

        return resultMap;
    }

    @GetMapping("/form")
    public String userForm() {
        return "ajax/userForm";
    }

    // 전달 받은 이메일이 이미 추가되었는지 확인하는 API
    @ResponseBody
    @GetMapping("/duplicate-email")
    public Map<String, Boolean> isDuplicateEmail(@RequestParam("email") String email) {

        Map<String, Boolean> resultMap = new HashMap<>();
        if(userService.isDuplicateEmail(email)) {
            // 중복됨
            // {"isDuplicate":true}
            resultMap.put("isDuplicate", true);
        } else {
            // 중복 안됨
            // {"isDuplicate":false}
            resultMap.put("isDuplicate", false);
        }

        return resultMap;

    }

}
