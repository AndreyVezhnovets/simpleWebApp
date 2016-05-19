package MyPro.ONE.service.anserws;

import MyPro.ONE.entity.Answers;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AnswersServiceImpl implements AnswersService{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Answers getAnswerById(int id) {        return sessionFactory.getCurrentSession().get(Answers.class, id);    }

    @Override
    public void create(Answers answers) { sessionFactory.getCurrentSession().save(answers);    }

    @Override
    public List<Answers> getAllIdAnswersByNews(int id) {
        String ss= "SELECT message FROM answers A WHERE A.news_id = "+id;
        return sessionFactory.getCurrentSession().createSQLQuery(ss).list();
    }


    @Override
    public void delete(Answers answers) {sessionFactory.getCurrentSession().delete(answers);    }

    @Override
    public void update(Answers answers) {sessionFactory.getCurrentSession().update(answers);    }

}
