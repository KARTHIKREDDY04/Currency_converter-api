package com.example.currencyconverter.service;

import com.example.currencyconverter.entity.ConversionHistory;
import com.example.currencyconverter.repository.ConversionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConversionService {

    private final CurrencyService currencyService;
    private final ConversionRepository repository;

    public ConversionHistory convert(String from, String to, double amount, String apiKey) {

        double rate = currencyService.getRate(from, to);
        double converted = amount * rate;

        ConversionHistory history = new ConversionHistory(
                null,
                from,
                to,
                amount,
                converted,
                rate,
                LocalDateTime.now(),
                apiKey
        );

        return repository.save(history);
    }

    public List<ConversionHistory> getHistory(String apiKey) {
        return repository.findByApiKey(apiKey);
    }
}
