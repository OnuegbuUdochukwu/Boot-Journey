package com.codewithudo.currencyconverterapi.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    // Static exchange rates (as an example — in a real app you'd fetch live rates)
    private final Map<String, Double> exchangeRates = new HashMap<>();

    public CurrencyService() {
        // Sample static rates relative to USD
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("NGN", 1550.0);
        exchangeRates.put("JPY", 155.0);
        exchangeRates.put("CAD", 1.35);
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Unsupported currency");
        }

        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);

        double amountInUSD = amount / fromRate;
        return amountInUSD * toRate;
    }

    public Map<String, Double> getExchangeRates() {
        return exchangeRates;
    }
}
