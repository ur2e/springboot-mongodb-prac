package com.probono.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {

    // trigger   when post
    @Bean
    public ValidatingMongoEventListener validationMongoEventListener() {
        return new ValidatingMongoEventListener((validatior()));
    }

    @Bean
    public LocalValidatorFactoryBean validatior() {
        return new LocalValidatorFactoryBean();
    }
}
