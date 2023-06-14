package com.test.JPAdemo.controller;

import com.test.JPAdemo.dto.TeacherDTO;
import com.test.JPAdemo.service.TeacherService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public String save(@Valid @RequestBody TeacherDTO dto) {
        return teacherService.save(dto).toString();
    }

    @DeleteMapping("/{id}")
    public String delete(@Valid @NotNull @PathVariable("id") Long id) {

        return teacherService.delete(id);
    }

    @PutMapping("/{id}")
    public TeacherDTO update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody TeacherDTO dto) {
        return teacherService.update(id, dto);
    }

    @GetMapping("/{id}")
    public TeacherDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return teacherService.getById(id);
    }

    @GetMapping
    public List<TeacherDTO> findAll() {
        return teacherService.findAll();
    }
}
