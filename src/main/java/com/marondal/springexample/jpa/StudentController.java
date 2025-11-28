package com.marondal.springexample.jpa;

import com.marondal.springexample.jpa.domain.Student;
import com.marondal.springexample.jpa.repository.StudentRepository;
import com.marondal.springexample.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // !!!! 경고!!!!!!!
    // 절대 Controller에서 Repository 객체를 활용하지 않는다!!!
    // 다만, 코드 작성 편의를 위해서 임시로 활용
    @Autowired
    private StudentRepository studentRepository;


    @ResponseBody
    @GetMapping("/lombok")
    public Student lombokTest() {

//        Student student = new Student(3
//                , "김인규"
//                , "010-1111-2222"
//                , "lecture@hagulu.com"
//                , "개발자"
//                , LocalDateTime.now()
//                , LocalDateTime.now());


        // bulder 패턴을 통한 객체 생성
        Student student = Student.builder()
                .name("김인규")
                .phoneNumber("010-1111-2222")
                .dreamJob("강사")
                .build();

        return student;

    }

    @ResponseBody
    @GetMapping("/add")
    public Student addStudent() {
        // 김인규, 010-1111-2222, lecture@hagulu.com, 개발자
        Student student = studentService.createStudent("김인규", "010-1111-2222", "lecture@hagulu.com", "개발자");

        return student;
    }

    @ResponseBody
    @GetMapping("/modify")
    public Student modifyStudent() {
        // id 가 3인 학생의 장래희망을 강사로 변경
        Student student = studentService.updateStudent(3, "강사");

        return student;
    }

    @ResponseBody
    @GetMapping("/remove")
    public String removeStudent() {
        // id가 3인 학생 삭제
        studentService.deleteStudent(3);

        return "삭제 완료";
    }

    @ResponseBody
    @GetMapping("/find")
    public List<Student> findStudent() {

        List<Student> studentList = null;
        // 모든 행 조회
//        studentList = studentRepository.findAll();
//        studentList = studentRepository.findByName("조세호");
//        studentList = studentRepository.findByOrderByIdDesc();

//        studentList = studentRepository.findTop2ByNameOrderByIdDesc("김인규");
        List<String> nameList = new ArrayList<>();
        nameList.add("유재석");
        nameList.add("김인규");

//        studentList = studentRepository.findByNameIn(nameList);
        studentList = studentRepository.selectByDreamJob("개발자");

        return studentList;

    }


}
