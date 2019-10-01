package ru.stacy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stacy.domain.Student;
import ru.stacy.repository.StudentRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student findStudentById(Long id) {
        return studentRepository.getOne(id);
    }

    public List<Student> findAllStudentsByAgeMoreTwenty() {
        return studentRepository.findAllStudentsByAgeMoreTwenty();
    }

    public List<Student> findAllStudentsByName(String name) {
        return studentRepository.findAllStudentsByName(name);
    }
}
