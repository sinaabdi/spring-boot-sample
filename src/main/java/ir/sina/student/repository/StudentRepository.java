package ir.sina.student.repository;

import ir.sina.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student getById(int id);
}
