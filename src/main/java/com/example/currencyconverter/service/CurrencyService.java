package com.example.currencyconverter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class CurrencyService {

    private final WebClient webClient = WebClient.create();

    public double getRate(String from, String to) {

        String url = "https://api.exchangerate-api.com/v4/latest/" + from;

        Map<String, Object> response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        Map<String, Double> rates = (Map<String, Double>) response.get("rates");

        if (rates == null || !rates.containsKey(to)) {
            throw new RuntimeException("Invalid currency");
        }

        return rates.get(to);
    }
}
