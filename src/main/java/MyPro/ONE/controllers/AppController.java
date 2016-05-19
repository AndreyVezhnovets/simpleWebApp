package MyPro.ONE.controllers;
import MyPro.ONE.service.anserws.AnswersService;
import MyPro.ONE.service.news.NewsService;
import MyPro.ONE.service.user.UsersService;
import MyPro.ONE.entity.Answers;
import MyPro.ONE.entity.News;
import MyPro.ONE.entity.Depository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Date;

@Controller
public class AppController {

    @Autowired
    AnswersService answersService;
    @Autowired
    UsersService usersService;
    @Autowired
    NewsService newsService;

    @RequestMapping(value ="/", method = {RequestMethod.GET})
    public String welcomePage()
    {
              return "../startPage";
    }

    @RequestMapping(value ="/123{newsNumber}" , method = RequestMethod.GET)
    public String Log11 (@RequestParam int newsNumber, Model model){
    model.addAttribute("news",newsService.getLastNews(newsNumber));
        return "newsS";
    }

    @RequestMapping (value ="/page{newsNumber}")
    public String pageNumber(@RequestParam int newsNumber, Model model ){
        Depository.setActivNews_id(newsNumber);
        model.addAttribute("news", newsService.getNewsById(newsNumber));
        return "../standardPost";
    }

    @RequestMapping (value ="/answerNumber{answerNumber}")
    public String answerNumber(@RequestParam int answerNumber, Model model ){
        model.addAttribute("answer",newsService.getAllAnswersByNwesId(Depository.getActivNews_id()).get(newsService.getAllAnswersByNwesId(Depository.getActivNews_id()).size()-answerNumber));
        return "answer";
    }

    @RequestMapping (value = "/sendAnswer{msg}", method = RequestMethod.GET)
    public void  aaaa(@RequestParam String msg){

        Answers answers= new Answers();
        answers.setMessage(msg);
        answers.setAnswerDate( new Date());
        answers.setUsers_name(Depository.getUserName());
        answers.setNews_id(Depository.getActivNews_id());
        answersService.create(answers);
    }

    @RequestMapping (value = "/regLoader", method = RequestMethod.GET)
    public String regLoader(){
        return "regMenu";
    }

    @RequestMapping(value = "/Suc", method = RequestMethod.GET)
    public String Zz() {
        return "closed";
    }

    @RequestMapping(value = "/userName{userName}", method = RequestMethod.GET)
    public String userName(@RequestParam String userName) {
        String nameUser;
        try {
            System.out.println(userName);
            nameUser = usersService.getStudentByName(userName).getName();
            System.out.println(nameUser);
            return "ajaxObj/pusto";
        } catch (Exception e) {
            return "ajaxObj/otvetOtr";
        }
    }

    @RequestMapping(value = {"/fail"}, method = {RequestMethod.GET})
    public String FailPage() {
        return "failPage";
    }

    @RequestMapping(value = "/closed**", method = RequestMethod.GET)
    public String closedPage() {
        return "closed";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String protectedPage() {
        return "protected";
    }

    @RequestMapping(value = "/confidential**", method = RequestMethod.GET)
    public String confidentialPage() {
        return "confidential";
    }

    @RequestMapping(value = "/protected/1", method = RequestMethod.GET)
    public String LogOut(Model model) {
        model.addAttribute("news", new News());
                return "GetNewNews";
    }
    @RequestMapping(value = "/protected/2", method = RequestMethod.GET)
    public String LogOut1(@ModelAttribute News news, Model model) {
        news.setUsers_name(Depository.getUserName());
        news.setDate(new Date());
        newsService.saveNews(news);
        model.addAttribute("news", news);

        return "GetNewNews";
    }

}
