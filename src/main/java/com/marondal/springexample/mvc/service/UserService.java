package com.marondal.springexample.mvc.service;

import com.marondal.springexample.mvc.domain.User;
import com.marondal.springexample.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 가장 최근 등록된 사용자 정보 얻어오기
    public User getLastUser() {

        // new_user 테이블의 가장 최근 추가된 행 조회
        User user = userRepository.selectLastUser();

        return user;
    }

    public int createUser(
            String name
            , String birthday
            , String email
            , String introduce) {

        int count = userRepository.insertUser(name, birthday, email, introduce);

        return count;
    }
}
