package MyPro.ONE.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationProviderImpl userDetailsService;

	@Autowired
	public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
			auth.authenticationProvider(userDetailsService);
	     }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		    http.csrf()
				.disable()
				.authorizeRequests()
			    .antMatchers("/protected/**").hasAnyRole("ADMIN","USER")
				.antMatchers("/").permitAll()
				.and().formLogin().loginPage("/login")
				.loginProcessingUrl("/Alogin")
				.usernameParameter("app_username")
				.passwordParameter("app_password")
				.defaultSuccessUrl("/closed",false )
				.failureUrl("/fail")
				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/logout");
	}
	}

