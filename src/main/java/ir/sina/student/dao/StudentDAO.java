package ir.sina.student.dao;

import ir.sina.student.model.Student;

import java.util.List;

public interface StudentDAO {

    public List<Student> findAll();
    public Student getById(int id);
    public void save(Student student);
    public void deleteById(int id);
}
