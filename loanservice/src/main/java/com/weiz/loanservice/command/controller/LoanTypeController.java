package com.weiz.loanservice.command.controller;

import com.weiz.loanservice.command.model.LoanTypeRequest;
import com.weiz.loanservice.command.model.LoanTypeUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/loan-types")
public interface LoanTypeController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    String addLoanType(@RequestBody LoanTypeRequest request);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    String updateLoanType(@PathVariable final String id, @RequestBody LoanTypeUpdateRequest request);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    String deleteLoanType(@PathVariable final String id);
}
