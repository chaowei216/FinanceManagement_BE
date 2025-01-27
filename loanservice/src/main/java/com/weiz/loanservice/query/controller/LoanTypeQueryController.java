package com.weiz.loanservice.query.controller;

import com.weiz.loanservice.query.model.LoanTypeResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/loan-types")
@Tag(name = "Loan Type Query Controller")
public interface LoanTypeQueryController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<LoanTypeResponseDTO> getLoanTypes();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    LoanTypeResponseDTO getLoanType(@PathVariable String id);
}
