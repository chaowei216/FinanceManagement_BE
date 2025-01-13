package com.weiz.loanservice.command.command.loans;

import com.weiz.loanservice.command.data.enums.LoanStatusEnum;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLoanCommand {

    @TargetAggregateIdentifier
    String id;
    LoanStatusEnum status;
}
