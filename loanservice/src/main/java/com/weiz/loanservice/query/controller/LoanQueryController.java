package com.weiz.loanservice.query.controller;

import com.weiz.loanservice.query.model.LoanResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping("/api/v1/loans")
@Tag(name = "Loan Query Controller")
public interface LoanQueryController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<LoanResponseDTO> getLoanTypes();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    LoanResponseDTO getLoanType(@PathVariable String id);
}
