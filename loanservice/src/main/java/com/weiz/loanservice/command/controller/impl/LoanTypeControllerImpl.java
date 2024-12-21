package com.weiz.loanservice.command.controller.impl;

import com.weiz.loanservice.command.command.CreateLoanTypeCommand;
import com.weiz.loanservice.command.controller.LoanTypeController;
import com.weiz.loanservice.command.model.LoanTypeRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoanTypeControllerImpl implements LoanTypeController {

    CommandGateway commandGateway;

    @Override
    public String addLoanType(LoanTypeRequest request) {
        log.info("LOAN TYPE CONTROLLER: Add loan type request...");
        CreateLoanTypeCommand command = CreateLoanTypeCommand.builder()
                .name(request.getName())
                .description(request.getDescription())
                .interestRate(request.getInterestRate())
                .maxAmount(request.getMaxAmount())
                .maxTerm(request.getMaxTerm())
                .minAmount(request.getMinAmount())
                .minTerm(request.getMinTerm())
                .build();

        return commandGateway.sendAndWait(command);
    }


}
