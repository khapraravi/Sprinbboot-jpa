package com.dailycode.Spring.Data.Jpa.repository;

import com.dailycode.Spring.Data.Jpa.entities.Gaurdian;
import com.dailycode.Spring.Data.Jpa.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveStudent(){
        Student stu = Student.builder()
                .emailId("aman@gmail.com")
                .firstName("Aman")
                .lastName("Gupta")
                .build();

        studentRepository.save(stu);

    }

    @Test
    public void saveStudentwithgaurdian(){
        Gaurdian gaurd = Gaurdian.builder()
                .name("Nikhi")
                .email("nikhi@gmail.com")
                .mobile("987789897")
                .build();

        Student stud = Student.builder()
                .firstName("Shuvam")
                .lastName("Gupta")
                .emailId("shivam@gmail.com")
                .gaurdian(gaurd)
                .build();

        studentRepository.save(stud);
    }

    @Test
    public void getStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);

    }

    @Test
    public void findStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("aman");
        System.out.println(students);
    }
    
    @Test
    public void findByFirstNameContains(){
        List<Student> studs = studentRepository.findByFirstNameContains("shu");

        System.out.println("studs = " + studs);
    }
    
    @Test
    public void findByLastNameNotNull(){
        List<Student> stud = studentRepository.findByLastNameNotNull();
        System.out.println("stud = " + stud);
    }

    @Test
    public void findByGaurdianNameNotNull(){
        List<Student> stud = studentRepository.findByGaurdianNameNotNull();
        System.out.println("stud = " + stud);
    }

    @Test
    public void findByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("shivam@gmail.com");

        System.out.println("student = " + student);
    }
    
    @Test
    public void findFirstNameByEmailAddress(){
        String firstname = studentRepository.getStudentFirstNameByEmailAddress("shivam@gmail.com");

        System.out.println("firstname = " + firstname);
    }
    
    @Test
    public void findStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNativeParam("shivam@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void updateFirstNameByEmailAddress(){
        int hel = studentRepository.updateFirstNameByEmailAddress("Rohan","shivam@gmail.com");
        Student student = studentRepository.getStudentByEmailAddressNativeParam("shivam@gmail.com");

        System.out.println("student = " + student);

    }
}