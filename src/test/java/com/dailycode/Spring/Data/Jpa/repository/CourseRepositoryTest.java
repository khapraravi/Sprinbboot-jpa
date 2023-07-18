package com.dailycode.Spring.Data.Jpa.repository;

import com.dailycode.Spring.Data.Jpa.entities.Course;
import com.dailycode.Spring.Data.Jpa.entities.Student;
import com.dailycode.Spring.Data.Jpa.entities.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course> cc = courseRepository.findAll();
        System.out.println("cc = " + cc);
    }

    @Test
    public void saveWithTeacher(){
        Teacher teach = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();



        Course cour = Course.builder()
                .courseCredit(7)
                .courseTitle("java")
                .teacher(teach)
                .build();

        courseRepository.save(cour);
    }


    @Test
    public void pagination(){
        Pageable firstpagewiththree = PageRequest.of(0,3);
        Pageable twopagewithtwo = PageRequest.of(0,2);

        List<Course> courses = courseRepository.findAll(firstpagewiththree).getContent();


        long totalelements = courseRepository.findAll(firstpagewiththree).getTotalElements();

        System.out.println("totalelements = " + totalelements);

        long totalpages = courseRepository.findAll(firstpagewiththree).getTotalPages();
        System.out.println("totalpages = " + totalpages);

        System.out.println("courses = " + courses);



    }
    
    
    
    @Test
    public void sorting(){
        Pageable withthree = PageRequest.of(0,10, Sort.by("courseTitle").ascending());
        List<Course> course = courseRepository.findAll(withthree).getContent();

        for(Course c:course)
            System.out.println(c);
    }


    @Test
    public void saveCourseWithStudentandTeacher(){

        Teacher teach = Teacher.builder()
                .firstName("Kiran")
                .lastName("Rao")
                .build();

        Student student = Student.builder()
                .firstName("david")
                .lastName("webb")
                .emailId("david@gmail.com")
                .build();

        Course course = Course.builder()
                .courseTitle("AI")
                .courseCredit(14)
                .teacher(teach)
                .build();
        
        course.addStudents(student);
        courseRepository.save(course);

        System.out.println("course = " + course);
    }
}