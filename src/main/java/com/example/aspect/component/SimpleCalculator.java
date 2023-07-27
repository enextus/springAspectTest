package com.example.aspect.component;

import org.springframework.stereotype.Component;

@Component
public class SimpleCalculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}
