package com.codeyourwork.demo.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {


    @Bean
    public UserDetailsService userDetailsService(){


        return new JdbcUserDetailsManager(dataSource());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dds=new DriverManagerDataSource();

        dds.setUrl("jdbc:postgresql://localhost:5432/spring");
        dds.setUsername("postgres");
        dds.setPassword("root");

        return dds;
    }


}
