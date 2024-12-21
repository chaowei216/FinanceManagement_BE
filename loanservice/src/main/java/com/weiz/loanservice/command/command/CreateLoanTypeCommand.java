package com.weiz.loanservice.command.command;

import com.weiz.loanservice.command.data.enums.LoanTypeStatusEnum;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLoanTypeCommand {

    @TargetAggregateIdentifier
    String name;
    Long minAmount;
    Long maxAmount;
    Double interestRate;
    Integer minTerm;
    Integer maxTerm;
    String description;
    LoanTypeStatusEnum status;
}
