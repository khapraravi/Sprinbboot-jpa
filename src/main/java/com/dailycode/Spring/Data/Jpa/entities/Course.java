package com.dailycode.Spring.Data.Jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence", allocationSize = 1,sequenceName = "course_sequence")
    @GeneratedValue(generator = "course_sequence",strategy = GenerationType.SEQUENCE)
    private Long courseId;
    private String courseTitle;

    private Integer courseCredit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
    private Teacher teacher;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course_map",
            joinColumns = @JoinColumn(name = "course_id",referencedColumnName = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "student_id",
                    referencedColumnName = "studentId"))
    private List<Student> students;
    public void addStudents(Student student){
        if(students == null)students = new ArrayList<>();
        students.add(student);

    }
}
