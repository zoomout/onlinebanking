package com.bogdan.config;


import com.bogdan.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.security.SecureRandom;

/**
 * Created by zoomout on 12/25/16.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment env;


    // Field userSecurityService in SecurityConfig required a bean of type
    // UserServiceImpl.UserSecurityService that could not be found.
    @Autowired
    private UserSecurityService userSecurityService;

    public @Bean UserSecurityService userSecurityService() {
        return new UserSecurityService();
    }

    private static final String SALT = "salt"; // Salt should be protected carefully

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }

    private static final String[] PUBLIC_MATCHERS =
      {"/webjars/**", "/css/**", "/js/**", "/images/**", "/", "/about/**", "/contact/**",
        "/error/**/*", "/console/**", "/signup"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
          //                antMatchers("/**").
            antMatchers(PUBLIC_MATCHERS).
          permitAll().anyRequest().authenticated();

        http.csrf().disable().cors().disable().formLogin().failureUrl("/index?error")
          .defaultSuccessUrl("/userFront").loginPage("/index").permitAll().and().logout()
          .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
          .logoutSuccessUrl("/index?logout").deleteCookies("remember-me").permitAll().and()
          .rememberMe();
    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //    	 auth.inMemoryAuthentication().withUser("user").password("password").roles("USER"); //This is in-memory authentication
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
    }
}

