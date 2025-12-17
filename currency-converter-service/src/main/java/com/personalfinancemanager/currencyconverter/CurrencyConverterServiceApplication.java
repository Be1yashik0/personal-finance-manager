package com.personalfinancemanager.currencyconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@SpringBootApplication
@RestController
public class CurrencyConverterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConverterServiceApplication.class, args);
    }

    // Simple stub for currency conversion
    private static final Map<String, BigDecimal> RATES = Map.of(
            "USD_EUR", new BigDecimal("0.92"),
            "EUR_USD", new BigDecimal("1.09")
    );

    @GetMapping("/convert")
    public String convert(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount) {
        String key = from.toUpperCase() + "_" + to.toUpperCase();
        BigDecimal rate = RATES.get(key);
        if (rate == null) {
            return "Conversion rate not found for " + key;
        }
        BigDecimal result = amount.multiply(rate);
        return String.format("%s %s is %s %s", amount, from.toUpperCase(), result, to.toUpperCase());
    }
}
