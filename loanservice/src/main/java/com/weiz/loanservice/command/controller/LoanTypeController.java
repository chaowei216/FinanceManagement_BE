package com.weiz.loanservice.command.controller;

import com.weiz.loanservice.command.model.LoanTypeRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/loan-types")
public interface LoanTypeController {

    @PostMapping
    String addLoanType(@RequestBody LoanTypeRequest request);
}
