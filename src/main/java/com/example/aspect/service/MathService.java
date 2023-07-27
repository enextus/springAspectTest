package com.example.aspect.service;

import com.example.aspect.component.SimpleCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    private final SimpleCalculator calculator;

    @Autowired
    public MathService(SimpleCalculator calculator) {
        this.calculator = calculator;
    }

    public int computeSum(int a, int b) {
        return calculator.add(a, b);
    }

    public int computeDifference(int a, int b) {
        return calculator.subtract(a, b);
    }
}
