package com.marondal.springexample.jpa.repository;

import com.marondal.springexample.jpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // 특정 이름과 일치하는 행 조회
    // WHERE `name` = #{name}
    public List<Student> findByName(String name);

    // id 기반으로 내림 차순 정렬
    // ORDER BY `id` DESC
    public List<Student> findByOrderByIdDesc();
    
    // 전달 받은 이름과 일치하는 행들을 id 기준으로 내림 차순으로 2개 조회
    // WHERE `name` = #{name} ORDER BY `id` DESC LIMIT 2
    public List<Student> findTop2ByNameOrderByIdDesc(String name);

    // 전달 받은 이름들과 일치하는 행 조회
    // WHERE `name` IN ();
    public List<Student> findByNameIn(List<String> nameList);

    // 쿼리 직접 작성
    // dreamJob 이 전달한 값과 일치하는 행조회
    @Query(value="SELECT * FROM `new_student` WHERE `dream_job` = :dreamJob", nativeQuery=true)
    public List<Student> selectByDreamJob(@Param("dreamJob") String dreamJob);

}
