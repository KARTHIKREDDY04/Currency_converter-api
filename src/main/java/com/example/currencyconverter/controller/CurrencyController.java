package com.example.currencyconverter.controller;

import com.example.currencyconverter.service.ConversionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final ConversionService service;

    @PostMapping("/convert")
    public ResponseEntity<?> convert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount,
            HttpServletRequest request) {

        String apiKey = (String) request.getAttribute("apiKey");

        return ResponseEntity.ok(service.convert(from, to, amount, apiKey));
    }

    @GetMapping("/history")
    public ResponseEntity<?> history(HttpServletRequest request) {

        String apiKey = (String) request.getAttribute("apiKey");

        return ResponseEntity.ok(service.getHistory(apiKey));
    }
}
