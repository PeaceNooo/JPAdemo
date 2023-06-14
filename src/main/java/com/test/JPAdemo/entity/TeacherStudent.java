package com.test.JPAdemo.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "teacher_student")
public class TeacherStudent {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
