package com.weiz.loanservice.command.controller;

import com.weiz.loanservice.command.model.loan.LoanCreateRequest;
import com.weiz.loanservice.command.model.loan.LoanUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/loans")
@Tag(name = "Loan Command Controller")
public interface LoanController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Add new loan",
            description = "ADD endpoint for loan",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Bad request",
                            responseCode = "400"
                    ),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401"
                    ),
                    @ApiResponse(
                            description = "Forbidden",
                            responseCode = "403"
                    )
            }
    )
    String addLoans(@Valid @RequestBody LoanCreateRequest request);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Update loan",
            description = "UPDATE endpoint for loan",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "204"
                    ),
                    @ApiResponse(
                            description = "Bad request",
                            responseCode = "400"
                    ),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401"
                    ),
                    @ApiResponse(
                            description = "Forbidden",
                            responseCode = "403"
                    )
            }
    )
    String updateLoan(@NotNull @PathVariable(name = "id") final String id,
                      @Valid @RequestBody LoanUpdateRequest request);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete loan",
            description = "DELETE endpoint for loan",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "204"
                    ),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401"
                    ),
                    @ApiResponse(
                            description = "Forbidden",
                            responseCode = "403"
                    )
            }
    )
    String deleteLoanType(@PathVariable final String id);

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody String message);
}
