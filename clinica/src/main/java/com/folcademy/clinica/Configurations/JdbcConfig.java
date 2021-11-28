package com.folcademy.clinica.Configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.driver-class-name}")
    private String dbDriverClassName;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(dbDriverClassName);
        dataSourceBuilder.url(datasourceUrl);
        dataSourceBuilder.username(dbUsername);
        dataSourceBuilder.password(dbPassword);
        return dataSourceBuilder.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

