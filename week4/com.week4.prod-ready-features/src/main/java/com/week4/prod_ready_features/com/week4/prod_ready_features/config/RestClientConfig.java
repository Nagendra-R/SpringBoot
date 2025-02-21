package com.week4.prod_ready_features.com.week4.prod_ready_features.config;



import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestClientConfig {


//    @Value("${employee.base.url}")
//    private String BASE_URL;

    @Bean
    RestClient getEmployeeRestClientConfig(){
        RestClient restClient = RestClient.builder()
                .baseUrl("http://localhost:8080/employees/")
                .defaultHeader(CONTENT_TYPE,APPLICATION_JSON_VALUE)
                .defaultStatusHandler(HttpStatusCode::is5xxServerError,(req, res)->{
                    System.out.println(new String(res.getBody().readAllBytes()));
                    throw new RuntimeException("Not getting Every employee");
                })
                .build();
        return restClient;
    }



}
