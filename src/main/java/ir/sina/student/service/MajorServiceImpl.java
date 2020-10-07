package ir.sina.student.service;

import ir.sina.student.model.Major;
import ir.sina.student.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorRepository majorRepository;


    @Override
    public List<Major> findAll() {
        return majorRepository.findAll();
    }

    @Override
    public Major getById(int id) {
        return majorRepository.getById(id);
    }

    @Override
    public void save(Major major) {
        majorRepository.save(major);
    }

    @Override
    public void deleteById(int id) {
        majorRepository.deleteById(id);
    }
}
