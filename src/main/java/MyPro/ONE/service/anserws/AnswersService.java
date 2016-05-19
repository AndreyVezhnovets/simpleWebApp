package MyPro.ONE.service.anserws;

import MyPro.ONE.entity.Answers;


import java.util.List;


public interface AnswersService {
    void create(Answers answers);

    void delete(Answers answers);

    void update(Answers answers);

    List<Answers> getAllIdAnswersByNews(int id);

    Answers getAnswerById(int id);




}
