package com.test.JPAdemo.entity;

import lombok.Data;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<TeacherStudent> teacherStudents = new ArrayList<>();

}
