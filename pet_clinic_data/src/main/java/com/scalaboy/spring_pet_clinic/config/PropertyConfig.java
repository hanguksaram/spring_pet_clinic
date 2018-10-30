package com.scalaboy.spring_pet_clinic.config;

import com.scalaboy.spring_pet_clinic.persistance.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    @Value("${com.user}")
    String user;
    @Value("${com.password}")
    String password;
    @Value("${com.url}")
    String url;

    @Bean
    public FakeDataSource fakeDataSource() {
        return new FakeDataSource(this.user, this.password, this.url);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return  propertySourcesPlaceholderConfigurer;
    }


}
