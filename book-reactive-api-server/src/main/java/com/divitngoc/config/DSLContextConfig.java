package com.divitngoc.config;

import io.r2dbc.spi.ConnectionFactory;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DSLConfig {

    @Bean
    public DSLContext dslContext(final ConnectionFactory connectionFactory) {
        return DSL.using(connectionFactory);
    }

}