package com.dailycode.Spring.Data.Jpa.repository;

import com.dailycode.Spring.Data.Jpa.entities.Course;
import com.dailycode.Spring.Data.Jpa.entities.CourseMaterial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMaterialRepository repository;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveCourseMaterial(){
         Course coursmew = Course.builder()
                 .courseTitle("Codebuffer")
                 .courseCredit(8)
                 .build();

        CourseMaterial cm = CourseMaterial.builder().course(coursmew).courseMaterialUrl("www.dcb.com").build();

        repository.save(cm);
    }

    @Test
    public void printCourses(){
        List<CourseMaterial> cm = repository.findAll();
        System.out.println("cm = " + cm);
        
    }

    
}