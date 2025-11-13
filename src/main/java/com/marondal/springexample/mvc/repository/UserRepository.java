package com.marondal.springexample.mvc.repository;

import com.marondal.springexample.mvc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {

    // new_user 테이블의 가장 최근 추가된 행 조회
    public User selectLastUser();

    public int insertUser(
            @Param("name") String name
            , @Param("birthday") String birthday
            , @Param("email") String email
            , @Param("introduce") String introduce);
}
