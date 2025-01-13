package com.weiz.loanservice.command.command.loantypes;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteLoanTypeCommand {

    @TargetAggregateIdentifier
    String id;
}
