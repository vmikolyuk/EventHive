package com.eventHive;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author vmikolyuk
 * @since 04.07.2023
 */
@Configuration
public class SwaggerConfiguration {
    
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("rest")
                .pathsToMatch("/rest/**")
                .build();
    }
}