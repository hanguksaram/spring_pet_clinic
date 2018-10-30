package com.scalaboy.spring_pet_clinic.config;

import com.scalaboy.spring_pet_clinic.persistance.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    /*system env variables mapping
    u can access it like env.getProperty("propertyname")
    */
    @Autowired
    Environment env;
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

    //if u uses application.properties spring default u shouldnt use properties configurer
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer properties() {
//        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//        return  propertySourcesPlaceholderConfigurer;
//    }


}
