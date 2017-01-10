package MyPro.ONE.entity;
import javax.persistence.*;
import javax.security.auth.Subject;
import java.io.Serializable;
import java.security.Principal;
import java.util.List;

@Entity
@Table(name = "users")
public class Users implements Serializable, Principal {
    @Override
    public boolean implies(Subject subject) {
        return true;
    }

    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password ")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany
    @JoinColumn(name = "user_name")
    private List <Answers> answers;

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    public Users() {
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}