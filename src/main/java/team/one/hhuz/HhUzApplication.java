package team.one.hhuz;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Hh.uz", version = "v1",
                description = "This API just for learning purposes",

                license = @License(name = "Apache Foundation", url = "http://apache.org")
        ),
        security = {
                @SecurityRequirement(
                        name = "Bearer"
                )
        }
)
@EnableCaching
@SpringBootApplication
public class HhUzApplication {

    public static void main(String[] args) {
        SpringApplication.run(HhUzApplication.class, args);
    }

}
