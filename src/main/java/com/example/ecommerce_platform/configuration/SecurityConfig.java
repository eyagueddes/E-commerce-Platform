package com.example.ecommerce_platform.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   // a "bean" is a reusable software component that is managed and instantiated by the Spring container.
    //When you mark a method with @Bean, it tells Spring that this method will return an object that should be registered as a bean in the Spring application context.
    // The object returned by the method will be managed by the Spring container, and you can use it in other parts of your application.


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("{spring.queries.roles-query}")
    private String rolesQuery;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .jdbcAuthentication()  // Use a JDBC-based authentication provider
                .usersByUsernameQuery(usersQuery)  // Specify the SQL query to retrieve user details
                .authoritiesByUsernameQuery(rolesQuery)  // Specify the SQL query to retrieve user roles
                .dataSource(dataSource)  // Set the data source for the database
                .passwordEncoder(bCryptPasswordEncoder);  // Use BCrypt to hash passwords
        System.out.println("done");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
               .antMatchers("/**").permitAll() // Allow access to certain paths without authentication
                .antMatchers("/auth/basicauth").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/product/add").permitAll()
                .antMatchers("/role/add").hasRole("ADMIN")
                .anyRequest().authenticated()// All other requests require authentication
               .and()
              .httpBasic(); // Enable httpBasic login

        // Optionally, you can add more configuration here (e.g., custom login page, logout handling, etc.)
    }

}


