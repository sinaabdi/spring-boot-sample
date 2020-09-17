package ir.sina.student.service;

import ir.sina.student.dao.StudentDAO;
import ir.sina.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student getById(int id) {
        return studentDAO.getById(id);
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }
}
