package com.pevinskevin.dronepizzafrontend.Service;

import com.pevinskevin.dronepizzafrontend.Model.Delivery;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiService {
    private final RestTemplate restTemplate;

    public ApiService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

   public List<Delivery> getDeliveries() {
    ResponseEntity<List<Delivery>> response = restTemplate.exchange(
        "localhost:8080/deliveries",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Delivery>>() {}
    );
    List<Delivery> deliveries = response.getBody();
    System.out.println("JSON Response: " + response);
    return deliveries;
}


}
