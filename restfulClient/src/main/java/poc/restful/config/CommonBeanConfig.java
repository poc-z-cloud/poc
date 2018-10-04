package poc.restful.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommonBeanConfig {

    @Bean
    public RestTemplate rest(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.basicAuthorization("admin", "admin").build();
    }
    

}