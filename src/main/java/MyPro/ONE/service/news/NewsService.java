package MyPro.ONE.service.news;


import MyPro.ONE.entity.News;

import java.util.List;

public interface NewsService {

    void saveNews(News news);

    void  updateNews (News news);

    void deliteNews (News news);

    News getNewsById(int id);

    News getLastNews(int i);

     List<Integer> getAll();

    List <String > getAllAnswersByNwesId (int i);


}
