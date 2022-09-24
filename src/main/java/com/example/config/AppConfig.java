package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@Component
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/").resourceChain(false);
        registry.setOrder(1);

    }
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setViewClass(JstlView.class);
        return internalResourceViewResolver;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/spring_mvc_db");
        driverManagerDataSource.setPassword("123");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        jdbcTemplate.setDataSource(driverManagerDataSource);
        return jdbcTemplate;

    }
}
