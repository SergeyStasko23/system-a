package ru.stacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.stacy.domain.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM Student s WHERE s.age > 20", nativeQuery = true)
    List<Student> findAllStudentsByAgeMoreTwenty();

    @Query(value = "SELECT * FROM Student s WHERE s.name = :name", nativeQuery = true)
    List<Student> findAllStudentsByName(@Param("name") String name);
}
