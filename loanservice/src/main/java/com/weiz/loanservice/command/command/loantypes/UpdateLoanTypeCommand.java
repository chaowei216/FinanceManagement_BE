package com.weiz.loanservice.command.command.loantypes;

import com.weiz.loanservice.command.data.enums.LoanTypeStatusEnum;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLoanTypeCommand {

    @TargetAggregateIdentifier
    String id;
    String name;
    Long minAmount;
    Long maxAmount;
    Double interestRate;
    Integer minTerm;
    Integer maxTerm;
    String description;
    LoanTypeStatusEnum status;
}
