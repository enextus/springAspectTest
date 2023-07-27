package com.example.aspect.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    public void performAction() {
        System.out.println("Выполняется действие в сервисе...");
    }
}
