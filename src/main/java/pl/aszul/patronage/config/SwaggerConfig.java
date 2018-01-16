package pl.aszul.patronage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.aszul.patronage"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "intive Patronage 2018 Backend (REST API)",
                "Goal: To design and implement REST API for car dealer",
                "2.0",
                "Terms of service",
                new Contact("Zerg Rush", "https://github.com/zerg-rush/Patronage1", "zerg-rush@dev.null"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}
