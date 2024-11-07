package com.weiz.finance.controller.impl;

import com.weiz.finance.controller.UserController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    @Override
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok("Hello World");
    }
}
