package com.weiz.loanservice.command.command.loans;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteLoanCommand {

    @TargetAggregateIdentifier
    String id;
}
