package com.example.mongodb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
//@EnableMongoRepositories(basePackageClasses =ListRepo.class)

class ApplicationConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName(){
        return "shoppingDB";
    }
}



