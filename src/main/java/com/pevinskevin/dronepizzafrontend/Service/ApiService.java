package com.pevinskevin.dronepizzafrontend.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pevinskevin.dronepizzafrontend.Model.Delivery;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class ApiService {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ApiService(ObjectMapper objectMapper) {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = objectMapper;
    }
    public List<Delivery> getDeliveries() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/deliveries"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), new TypeReference<List<Delivery>>() {});
        } else {
            throw new RuntimeException("Failed to fetch deliveries. HTTP code: " + response.statusCode());
        }
    }
}
