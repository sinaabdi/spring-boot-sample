package ir.sina.student.service;

import ir.sina.student.dao.MajorDAO;
import ir.sina.student.model.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorDAO majorDAO;


    @Override
    @Transactional
    public List<Major> findAll() {
        return majorDAO.findAll();
    }

    @Override
    @Transactional
    public Major getById(int id) {
        return majorDAO.getById(id);
    }

    @Override
    @Transactional
    public void save(Major major) {
        majorDAO.save(major);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        majorDAO.deleteById(id);
    }
}
