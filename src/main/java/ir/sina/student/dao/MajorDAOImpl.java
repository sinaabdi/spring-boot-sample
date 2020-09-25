package ir.sina.student.dao;

import ir.sina.student.model.Major;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MajorDAOImpl implements MajorDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Major> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Major> query = session.createQuery("from Major", Major.class);

        List<Major> majors = query.getResultList();

        return majors;
    }

    @Override
    public Major getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Major major = session.get(Major.class, id);

        return major;
    }

    @Override
    public void save(Major major) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(major);
    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Major where id =:majorId");
        query.setParameter("majorId", id);
        query.executeUpdate();
    }
}
