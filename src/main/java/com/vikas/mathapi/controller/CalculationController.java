package com.vikas.mathapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.websocket.server.PathParam;

import com.vikas.mathapi.service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/math")
public class CalculationController {

    @Autowired
    CalculatorService calculatorService;

    // A single end point based on the value of the to handle all requests
    @GetMapping("/{operator}/{operands}")
    public String calculator(@PathVariable String operator, @PathVariable List<Double> operands) {
        if ("add".equalsIgnoreCase(operator)) {
            return String.valueOf(calculatorService.add(operands));
        } else if ("sub".equalsIgnoreCase(operator)) {
            return String.valueOf(calculatorService.sub(operands));
        } else if ("mul".equalsIgnoreCase(operator)) {
            return String.valueOf(calculatorService.mul(operands));
        } else if ("div".equalsIgnoreCase(operator)) {
            return String.valueOf(calculatorService.div(operands));
        } else {
            return "Invalid operator";
        }
    }
}
