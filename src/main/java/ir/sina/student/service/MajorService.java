package ir.sina.student.service;

import ir.sina.student.model.Major;

import java.util.List;

public interface MajorService {
    public List<Major> findAll();
    public Major getById(int id);
    public void save(Major major);
    public void deleteById(int id);
}
