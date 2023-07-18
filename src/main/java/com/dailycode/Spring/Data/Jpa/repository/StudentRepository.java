package com.dailycode.Spring.Data.Jpa.repository;

import com.dailycode.Spring.Data.Jpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String name);
    List<Student> findByFirstNameContains(String ch);

    List<Student> findByLastNameNotNull();

    List<Student> findByGaurdianNameNotNull();

    @Query("select s from Student s where s.emailId = ?1")
   Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    @Query(
            value = "select * from student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    @Query(
            value = "select * from student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeParam(@Param("emailId") String emailId);


    @Modifying
    @Transactional
    @Query(
            value = "update student set first_name = :firstName where email_address = :emailId",
            nativeQuery = true
    )
    int updateFirstNameByEmailAddress(
            @Param("firstName") String firstName,
            @Param("emailId") String emailId);

}
