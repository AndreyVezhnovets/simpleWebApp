package MyPro.ONE.service.news;


import MyPro.ONE.entity.News;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveNews(News news) {
              sessionFactory.getCurrentSession().save(news);
    }
    @Override
    public void updateNews(News news) {
      sessionFactory.getCurrentSession().update(news);
    }
    @Override
    public void deliteNews(News news) {
      sessionFactory.getCurrentSession().delete(news);
    }
    @Override
    public News getNewsById(int id) {
        return sessionFactory.getCurrentSession().get(News.class,id);
    }
    @Override
    public News getLastNews(int i) {
        return sessionFactory.getCurrentSession().get(News.class,getAll().size()-i+1);
    }

  @Override
    public List<String> getAllAnswersByNwesId(int i) {
        String qyery= "SELECT message FROM answers WHERE news_id="+i;
        return sessionFactory.getCurrentSession().createSQLQuery(qyery).list();
    }

    @Override
    public List<Integer> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(News.class).list();
    }
}
