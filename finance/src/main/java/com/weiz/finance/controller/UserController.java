package com.weiz.finance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
public interface UserController {

    @GetMapping("/")
    ResponseEntity<String> getTest();
}
