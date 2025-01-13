package com.weiz.loanservice.command.model.loan;

import com.weiz.loanservice.command.data.LoanType;
import com.weiz.loanservice.command.data.enums.LoanStatusEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanCreateRequest {

    @Min(value = 0, message = "minimum is 0")
    Long amount;

    @DecimalMin(value = "0.01", message = "rate must be 0.01 at least")
    Double interestRate;

    @NotNull
    LocalDate startDate;

    @NotNull
    @Future
    LocalDate endDate;

    @Min(value = 1, message = "min term must be 1 at least")
    int term;

    @Min(value = 0, message = "minimum is 0")
    Long installmentAmount;

    @NotNull
    String loanTypeId;

    @NotNull
    String userId;
}
