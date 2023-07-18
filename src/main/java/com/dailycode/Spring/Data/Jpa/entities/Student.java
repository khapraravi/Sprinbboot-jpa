package com.dailycode.Spring.Data.Jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "email_address",columnNames = "email_address"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private String firstName;
    private String lastName;
    @Column(name = "email_Address",nullable = false)
    private String emailId;
    @Id
    @SequenceGenerator(name = "student_squence",sequenceName ="student_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    private Long studentId;
    @Embedded
    private Gaurdian gaurdian;
}
