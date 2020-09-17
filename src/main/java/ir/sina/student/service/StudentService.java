package ir.sina.student.service;

import ir.sina.student.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();
    public Student getById(int id);
    public void save(Student student);
    public void deleteById(int id);

}
