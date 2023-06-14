package com.test.JPAdemo.controller;

import com.test.JPAdemo.dto.StudentDTO;
import com.test.JPAdemo.dto.TeacherDTO;
import com.test.JPAdemo.service.StudentService;
import com.test.JPAdemo.service.TeacherStudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    private final TeacherStudentService teacherStudentService;

    @Autowired
    public StudentController(StudentService studentService, TeacherStudentService teacherStudentService) {
        this.studentService = studentService;
        this.teacherStudentService = teacherStudentService;
    }

    // Create a new student
    @PostMapping
    public String save(@Valid @RequestBody StudentDTO dto) {
        return studentService.save(dto).toString();
    }

    // Delete a student by studentId
    @DeleteMapping("/{studentId}")
    public String delete(@Valid @NotNull @PathVariable("studentId") Long studentId) {
        studentService.delete(studentId);
        return "Student with id " + studentId + " was deleted";
    }

    // Update a student by studentId
    @PutMapping("/{studentId}")
    public StudentDTO update(@Valid @NotNull @PathVariable("studentId") Long studentId,
                       @Valid @RequestBody StudentDTO dto) {
        return studentService.update(studentId, dto);
    }

    // Get a student by studentId
    @GetMapping("/{studentId}")
    public StudentDTO getById(@Valid @NotNull @PathVariable("studentId") Long studentId) {
        return studentService.getById(studentId);
    }

    // Get all students
    @GetMapping
    public List<StudentDTO> findAll() {
        return studentService.findAll();
    }

    // Get all teachers for a student
    @GetMapping("/{studentId}/teachers")
    public List<TeacherDTO> getTeachersForStudent(@PathVariable Long studentId) {
        return teacherStudentService.getTeachersForStudent(studentId);
    }

    // Add a new teacher to a student
    @PostMapping("/{studentId}/teachers/{teacherId}")
    public String addTeacherToStudent(@PathVariable Long studentId, @PathVariable Long teacherId) {
        teacherStudentService.addTeacherToStudent(studentId, teacherId);
        return "Teacher with id " + teacherId + " was added to student with id " + studentId;
    }

    // Delete a teacher from a student
    @DeleteMapping("/{studentId}/teachers/{teacherId}")
    public String deleteTeacherFromStudent(@PathVariable Long studentId, @PathVariable Long teacherId) {
        teacherStudentService.deleteTeacherFromStudent(studentId, teacherId);
        return "Teacher with id " + teacherId + " was deleted from student with id " + studentId;
    }
}
