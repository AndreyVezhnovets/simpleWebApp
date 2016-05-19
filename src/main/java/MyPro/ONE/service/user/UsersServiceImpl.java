package MyPro.ONE.service.user;
import MyPro.ONE.entity.Users;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class UsersServiceImpl implements UsersService {
     private String usenName="";

    public String getUsenName() {
        return usenName;
    }

    public void setUsenName(String usenName) {
        this.usenName = usenName;
    }

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveUser(Users users) {
    sessionFactory.getCurrentSession().save(users);
    }

    @Override
    public void updateUser(Users users) {
    sessionFactory.getCurrentSession().update(users);
    }

    @Override
    public void deliteUser(Users users) {
    sessionFactory.getCurrentSession().delete(users);
    }

    @Override
    public Users getStudentByName(String name) {
        usenName=name;
        return sessionFactory.getCurrentSession().get(Users.class, name);
    }
}
