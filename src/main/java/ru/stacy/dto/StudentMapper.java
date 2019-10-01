package ru.stacy.dto;

import org.mapstruct.Mapper;
import ru.stacy.domain.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentDto toStudentDto(Student student);
    Student toStudent(StudentDto studentDto);
    List<StudentDto> toStudentDtos(List<Student> students);
    List<Student> toStudents(List<StudentDto> studentDtos);
}
