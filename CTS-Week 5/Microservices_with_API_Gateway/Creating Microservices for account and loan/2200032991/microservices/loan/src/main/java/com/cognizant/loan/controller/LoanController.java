package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable String number) {
        return Map.of(
            "number", number,
            "type", "car",
            "loan", 900000,
            "emi", 6345,
            "tenure", 20
        );
    }
}
