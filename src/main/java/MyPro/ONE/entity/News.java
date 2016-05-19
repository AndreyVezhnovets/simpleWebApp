package MyPro.ONE.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "news")
public class News implements Serializable {
    @Id
    @Column(name = "id_news")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "text")
    private String text;
    @Column (name = "title")
    private String title;
    @Column(name = "picture_url")
    private String picture_url;
    @Column(name = "users_name")
    private String users_name;
    @Column(name = "date")
   private Date date;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "news")
   public List<Answers> answersList;

    public News() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   public List<Answers> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answers> answersList) {
        this.answersList = answersList;
    }
}
