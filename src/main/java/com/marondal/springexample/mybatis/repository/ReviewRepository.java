package com.marondal.springexample.mybatis.repository;

import com.marondal.springexample.mybatis.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewRepository {
    
    // new_review 테이블에서  전달받은 id와 일치하는 행 조회
    public Review selectReview(@Param("id") int id);

    // 하나의 행을 insert 하는 기능
    public int insertReview(
            @Param("storeId") int storeId
            , @Param("menu") String menu
            , @Param("userName") String userName
            , @Param("point") double point
            , @Param("review") String review);

    public int insertReviewByObject(Review review);

}
