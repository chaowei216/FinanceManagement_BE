package com.weiz.loanservice.command.command.loans;

import com.weiz.loanservice.command.data.enums.LoanStatusEnum;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLoanCommand {

    @TargetAggregateIdentifier
    String id;
    Long amount;
    Double interestRate;
    LocalDate startDate;
    LocalDate endDate;
    LoanStatusEnum status;
    int term;
    Long installmentAmount;
    String loanTypeId;
    String userId;
}
