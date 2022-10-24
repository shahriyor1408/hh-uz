package com.company.hhuz.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "First Step Forward API", version = "v1",
                description = "This API is clone for hh.uz using spring boot",
                contact = @Contact(name = "B16", url = "https://pdp.uz", email = "john.lgd65@gmail.com"),
                license = @License(name = "Apache Foundation", url = "http://apache.org")
        ),
        security = {
                @SecurityRequirement(
                        name = "Bearer"
                )
        }
)
//@SecurityScheme(
//        name = "Bearer",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        scheme = "Bearer"
//)
public class OpenApiConfigurer {

}
