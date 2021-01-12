package com.vikas.mathapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.vikas.mathapi.service.CalculatorService;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/math")
public class CalculationController {
    private static Logger logger = LoggerFactory.getLogger(CalculationController.class);
    @Autowired
    CalculatorService calculatorService;

    @Autowired
    JSONObject jsonObject;

    private static final String RESULT = "result";

    // A single end point based on the value of the to handle all requests
    @GetMapping(value = "/{operator}/{operands}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String calculator(@PathVariable String operator, @PathVariable List<Double> operands) {
        if (operands.size() == 1) {
            return jsonObject.put(RESULT, String.valueOf(operands.get(0))).toString();
        }
        try {
            if ("add".equalsIgnoreCase(operator)) {
                return responseHelper(String.valueOf(calculatorService.add(operands)));
            } else if ("sub".equalsIgnoreCase(operator)) {
                return responseHelper(String.valueOf(calculatorService.sub(operands)));
            } else if ("mul".equalsIgnoreCase(operator)) {
                return responseHelper(String.valueOf(calculatorService.mul(operands)));
            } else if ("div".equalsIgnoreCase(operator)) {
                return responseHelper(String.valueOf(calculatorService.div(operands)));
            } else {
                return jsonObject.put(RESULT, "Invalid operator, please consider : add, sub, mul, div").toString();
            }
        } catch (Exception e) {
            logger.error("Exception is : ", e);
            return jsonObject.put(RESULT, "Something went wrong").toString();
        }
    }

    public String responseHelper(String result) {
        return jsonObject.put(RESULT, result).toString();
    }
}
