package com.ncgroup2.eventmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import javax.sql.DataSource;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT LOGIN, PASSWORD, TRUE FROM \"customer\" WHERE LOGIN=?")
                .authoritiesByUsernameQuery("select \"customer\".login, \"role\".name from \"customer\" join \"customer_role\" on \"customer\".id = \"customer_role\".customer_id\n" +
                        "  join \"role\" on \"role\".id = \"customer_role\".role_id WHERE \"customer\".login = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/").permitAll()
                    .antMatchers("/hello").hasRole("USER")
                    .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login").permitAll()
                .and()
                    .logout().permitAll()
                .and()
                    .csrf().disable();
    }
}
