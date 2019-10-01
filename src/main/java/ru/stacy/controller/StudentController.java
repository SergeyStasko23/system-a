package ru.stacy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stacy.domain.Student;
import ru.stacy.dto.StudentDto;
import ru.stacy.dto.StudentMapper;
import ru.stacy.service.StudentService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping(path = "/students")
    public ResponseEntity<List<StudentDto>> findAllStudents() {
        List<Student> students = studentService.findAllStudents();
        List<StudentDto> studentDtos = studentMapper.toStudentDtos(students);
        return ResponseEntity.ok(studentDtos);
    }

    @GetMapping(path = "/students/{studentId}")
    public ResponseEntity<StudentDto> findStudentById(@PathVariable(name = "studentId") Long id) {
        Student student = studentService.findStudentById(id);
        StudentDto studentDto = studentMapper.toStudentDto(student);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping(path = "/students-age")
    public ResponseEntity<List<StudentDto>> findAllStudentsByAgeMoreTwenty() {
        List<Student> students = studentService.findAllStudentsByAgeMoreTwenty();
        List<StudentDto> studentDtos = studentMapper.toStudentDtos(students);
        return ResponseEntity.ok(studentDtos);
    }

    @GetMapping(path = "/students-name")
    public ResponseEntity<List<StudentDto>> findAllStudentsByName(@RequestParam(name = "name") String name) {
        List<Student> students = studentService.findAllStudentsByName(name);
        List<StudentDto> studentDtos = studentMapper.toStudentDtos(students);
        return ResponseEntity.ok(studentDtos);
    }
 }
