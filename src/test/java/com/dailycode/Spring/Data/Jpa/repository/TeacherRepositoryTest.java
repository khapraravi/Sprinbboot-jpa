package com.dailycode.Spring.Data.Jpa.repository;

import com.dailycode.Spring.Data.Jpa.entities.Course;
import com.dailycode.Spring.Data.Jpa.entities.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveTeacher(){
        Course courseA = Course.builder()
                .courseCredit(4)
                .courseTitle("A")
                .build();

        Course courseB = Course.builder()
                .courseCredit(8)
                .courseTitle("C++")
                .build();

      Teacher teach = Teacher.builder()
                .firstName("Somya")
                .lastName("Chaturvedi")
              //  .courses(List.of(courseB,courseA))
                .build();
        teacherRepository.save(teach);
    }

}