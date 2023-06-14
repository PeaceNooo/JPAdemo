package com.test.JPAdemo.repo;

import com.test.JPAdemo.entity.Student;
import com.test.JPAdemo.entity.Teacher;
import com.test.JPAdemo.entity.TeacherStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TeacherStudentRepository extends JpaRepository<TeacherStudent, Long>, JpaSpecificationExecutor<TeacherStudent> {
    @Query("SELECT ts.teacher FROM TeacherStudent ts WHERE ts.student.studentId = :studentId")
    List<Teacher> findTeacherByStudentStudentId(Long studentId);

    Optional<TeacherStudent> findByStudent_StudentId(Long studentId);

//    Optional<TeacherStudent> findByTeacher_TeacherId(Long teacherId);

    Optional<TeacherStudent> findByStudentAndTeacher(Student student, Teacher teacher);

}
