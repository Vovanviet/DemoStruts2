package dao;

import entity.Student;
import org.hibernate.Session;
import utils.HibernateUtils;

public class StudentDaoImpl implements StudentDao{
    @Override
    public void create(Student student) {
        Session session= HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }
}
