package com.weiz.loanservice.command.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteLoanTypeCommand {

    @TargetAggregateIdentifier
    String id;
}
