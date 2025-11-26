package com.marondal.springexample.jpa.service;

import com.marondal.springexample.jpa.domain.Student;
import com.marondal.springexample.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(
            String name
            , String phoneNumber
            , String email
            , String dreamJob) {

        Student student = Student.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .dreamJob(dreamJob)
                .build();

        Student result = studentRepository.save(student);

        return result;

    }

    public Student updateStudent(int id, String dreamJob) {

        // 1. 수정 대상을 객체로 얻어 온다
        // 2. 해당 객체 정보에서 수정사항을 적용한다.
        // 3. 수정된 객체를 저장한다.

        // Optional
        // null일 가능성이 있는 객체를 감싸 놓은 객체
        // 감싼 객체가 null인 경우에 대한 처리를 위한 기능
        // null 인 상태에서 객체를 다룰때, NullPointerException의 윔험을 줄이기위한 용도
        // null 일 수 있는 객체를 리턴하는 메서드에서 리턴타입으로 활용
        // (내가 만든 메서드가 null을 리턴할 수 도 있으니 조심해서 다뤄라)
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent()) {
            // null이 아니다
            Student student = optionalStudent.get();

            student = student.toBuilder().dreamJob(dreamJob).build();

            Student result = studentRepository.save(student);

            return result;

        } else {
            // null 이다
            return null;
        }
    }

    public void deleteStudent(int id) {
        // 1. 삭제 대상을 객체로 얻어 온다
        // 2. 대상 객체로 삭제 한다

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentRepository.delete(student);
        }
    }
}
