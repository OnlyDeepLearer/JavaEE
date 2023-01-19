package uz.boom.javaee.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import uz.boom.javaee.config.HibernateConfig;
import uz.boom.javaee.servlets.domains.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public User findByUsername(String username) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<User> query = session.createQuery("select t from User t where t.username =:username", User.class);
        query.setParameter("username", username);
        User user = query.getSingleResultOrNull();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public User save(User user) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
