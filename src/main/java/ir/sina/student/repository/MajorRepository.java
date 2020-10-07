package ir.sina.student.repository;

import ir.sina.student.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, Integer> {
    Major getById(int id);
}
