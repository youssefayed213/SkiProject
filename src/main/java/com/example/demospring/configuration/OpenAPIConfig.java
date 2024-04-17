package com.example.demospring.configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Youssef Ayed")
                        .email("ayed.youssef@esprit.tn")
                .url("https://www.linkedin.com/in/ayedyoussef/");

        return contact;
    }

    public List<GroupedOpenApi> productPublicApi() {
        List<GroupedOpenApi> groupedOpenApis = new ArrayList<>();

        GroupedOpenApi skierManagementApi = GroupedOpenApi.builder()
                .group("Skier Management API")
                .pathsToMatch("/api/skieurs/**")
                .pathsToExclude("**")
                .build();

        GroupedOpenApi abonnementManagementApi = GroupedOpenApi.builder()
                .group("Abonnement Management API")
                .pathsToMatch("/api/abonnements/**")
                .pathsToExclude("**")
                .build();

        groupedOpenApis.add(skierManagementApi);
        groupedOpenApis.add(abonnementManagementApi);

        return groupedOpenApis;
    }
}
