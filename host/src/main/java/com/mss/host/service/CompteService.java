package com.mss.host.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CompteService {
    private final RestClient restClient;

    public CompteService(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Long> getCartesByCompte(Long idCompte) {
        String url = "http://CMS-SERVICE/api/cartes/compte/" + idCompte;
        return restClient.get().uri(url)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Long>>() {});
    }
}
