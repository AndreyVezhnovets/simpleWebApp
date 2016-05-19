package MyPro.ONE.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table (name="answers")
public class Answers implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "message")
    private String message;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "answerDate")
    private Date answerDate;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id", nullable = false , insertable = false, updatable = false)
    private News news;
    @Column(name = "news_id")
    private int news_id;

    public Answers() {
    }

    public Answers(int news_id) {
        this.news_id = news_id;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public String getUsers_name() {
        return user_name;
    }

    public void setUsers_name(String users_id) {
        this.user_name = users_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}


