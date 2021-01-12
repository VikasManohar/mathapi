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
    private static final String ERROR_RESULT = "Something went wrong";

    @GetMapping(value = "/add/{operands}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String calculatorAdd(@PathVariable List<Double> operands) {
        if (operands.size() == 1) {
            return jsonObject.put(RESULT, String.valueOf(operands.get(0))).toString();
        }
        try {
            return responseHelper(String.valueOf(calculatorService.add(operands)));
        } catch (Exception e) {
            logger.error("Exception is : ", e);
            return jsonObject.put(RESULT, ERROR_RESULT).toString();
        }
    }

    @GetMapping(value = "/sub/{operands}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String calculatorSub(@PathVariable List<Double> operands) {
        if (operands.size() == 1) {
            return jsonObject.put(RESULT, String.valueOf(operands.get(0))).toString();
        }
        try {
            return responseHelper(String.valueOf(calculatorService.sub(operands)));
        } catch (Exception e) {
            logger.error("Exception is : ", e);
            return jsonObject.put(RESULT, ERROR_RESULT).toString();
        }
    }

    @GetMapping(value = "/mul/{operands}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String calculatorMul(@PathVariable List<Double> operands) {
        if (operands.size() == 1) {
            return jsonObject.put(RESULT, String.valueOf(operands.get(0))).toString();
        }
        try {
            return responseHelper(String.valueOf(calculatorService.mul(operands)));
        } catch (Exception e) {
            logger.error("Exception is : ", e);
            return jsonObject.put(RESULT, ERROR_RESULT).toString();
        }
    }

    @GetMapping(value = "/div/{operands}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String calculatorDiv(@PathVariable List<Double> operands) {
        if (operands.size() == 1) {
            return jsonObject.put(RESULT, String.valueOf(operands.get(0))).toString();
        }
        try {
            return responseHelper(String.valueOf(calculatorService.div(operands)));
        } catch (Exception e) {
            logger.error("Exception is : ", e);
            return jsonObject.put(RESULT, ERROR_RESULT).toString();
        }
    }

    public String responseHelper(String result) {
        logger.info("result is : {}", result);
        return jsonObject.put(RESULT, result).toString();
    }
}
