package com.vikas.mathapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double add(List<Double> operands) {
        double result = 0;
        for (double operand : operands) {
            result += operand;
        }
        return result;
    }

    public double sub(List<Double> operands) {
        double result = 0;
        for (double operand : operands) {
            result -= operand;
        }
        return result;
    }

    public double mul(List<Double> operands) {
        double result = 1;
        for (double operand : operands) {
            result *= operand;
        }
        return result;
    }

    public double div(List<Double> operands) {
        double result = 0;
        for (double operand : operands) {
            result /= operand;
        }
        return result;
    }
}
