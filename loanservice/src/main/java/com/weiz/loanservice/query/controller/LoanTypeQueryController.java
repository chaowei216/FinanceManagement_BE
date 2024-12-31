package com.weiz.loanservice.query.controller;

import com.weiz.loanservice.query.model.LoanTypeResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/loan-types")
public interface LoanTypeQueryController {

    @GetMapping
    List<LoanTypeResponseDTO> getLoanTypes();

    @GetMapping("/{id}")
    LoanTypeResponseDTO getLoanType(@PathVariable String id);
}
