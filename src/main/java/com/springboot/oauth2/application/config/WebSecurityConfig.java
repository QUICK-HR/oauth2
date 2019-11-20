package com.springboot.oauth2.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 配置Security
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }
    @Override
    public void configure(WebSecurity web) throws Exception{
        super.configure(web);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        super.configure(http);
    }
    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
        User.UserBuilder builder = User.builder();
        UserDetails user = builder
                                 .username("liuhuanran")
                                 .password("$2a$10$.47lcwyT5sx8gs728lPYfeTU5Ykdl.nYqtLL4c6pccw/MWu/5DMIG")
                                 .roles("USER")
                                 .build();
        return new InMemoryUserDetailsManager(user);

    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }
}
