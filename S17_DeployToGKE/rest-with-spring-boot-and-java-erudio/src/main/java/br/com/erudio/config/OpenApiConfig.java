package br.com.erudio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.erudio.services.InstanceInformationService;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Autowired
    private InstanceInformationService service;
    
    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("REST API's RESTful from 0 to GCP with Java 21, Spring Boot 3.3.6, Docker and Kubernetes " + " V1 " + service.retrieveInstanceInfo())
                .version("v1")
                .description("Some description about your API")
                .termsOfService("https://pub.erudio.com.br/meus-cursos")
                .license(
                    new License()
                        .name("Apache 2.0")
                        .url("https://pub.erudio.com.br/meus-cursos")
                    )
                );
    }

}
