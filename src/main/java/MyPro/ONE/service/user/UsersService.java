package MyPro.ONE.service.user;
import MyPro.ONE.entity.Users;

public interface UsersService {

    void saveUser(Users users);
    void  updateUser (Users users);
    void deliteUser (Users users);
    Users getStudentByName(String id);

}

