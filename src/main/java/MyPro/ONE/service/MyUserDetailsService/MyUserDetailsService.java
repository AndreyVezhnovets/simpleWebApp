package MyPro.ONE.service.MyUserDetailsService;
import java.util.*;

import MyPro.ONE.service.user.UsersService;
import MyPro.ONE.entity.Depository;
import MyPro.ONE.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service("MyUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UsersService userService;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Users userInfo = userService.getStudentByName(username);
        Depository.setUserName(userInfo.getName());
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+userInfo.getRole());
        List <GrantedAuthority> aaa= new ArrayList<>();
        aaa.add(authority);

        UserDetails userDetails = (UserDetails)new User(userInfo.getName(),
               userInfo.getPassword(), aaa);


        return userDetails;
    }
}

