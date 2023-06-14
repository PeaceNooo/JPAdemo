package com.test.JPAdemo.controller;

import com.test.JPAdemo.dto.StudentDTO;
import com.test.JPAdemo.dto.TeacherDTO;
import com.test.JPAdemo.service.TeacherService;
import com.test.JPAdemo.service.TeacherStudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherService teacherService;

    private final TeacherStudentService teacherStudentService;

    @Autowired
    public TeacherController(TeacherService teacherService, TeacherStudentService teacherStudentService) {
        this.teacherService = teacherService;
        this.teacherStudentService = teacherStudentService;
    }

    // Create a new teacher
    @PostMapping
    public String save(@Valid @RequestBody TeacherDTO dto) {
        return teacherService.save(dto).toString();
    }

    // Delete a teacher by id
    @DeleteMapping("/{id}")
    public String delete(@Valid @NotNull @PathVariable("id") Long id) {

        return teacherService.delete(id);
    }

    // Update a teacher by id
    @PutMapping("/{id}")
    public TeacherDTO update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody TeacherDTO dto) {
        return teacherService.update(id, dto);
    }

    // Get a teacher by id
    @GetMapping("/{id}")
    public TeacherDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return teacherService.getById(id);
    }

    // Get all teachers
    @GetMapping
    public List<TeacherDTO> findAll() {
        return teacherService.findAll();
    }

    // Get all students for a teacher
    @GetMapping("/{teacherId}/students")
    public List<StudentDTO> getStudentsByTeacherId(@PathVariable Long teacherId) {
        return teacherStudentService.getStudentsByTeacherId(teacherId);
    }


    // Add a new student to a teacher
    @PostMapping("/{teacherId}/students/{studentId}")
    public String addStudentToTeacher(@PathVariable Long teacherId, @PathVariable Long studentId) {
        teacherStudentService.addStudentToTeacher(teacherId, studentId);
        return "Student with id " + studentId + " was added to teacher with id " + teacherId;
    }

    // Delete a student from a teacher
    @DeleteMapping("/{teacherId}/students/{studentId}")
    public String deleteStudentFromTeacher(@PathVariable Long teacherId, @PathVariable Long studentId) {
        teacherStudentService.deleteStudentFromTeacher(teacherId, studentId);
        return "Student with id " + studentId + " was deleted from teacher with id " + teacherId;

    }

}
