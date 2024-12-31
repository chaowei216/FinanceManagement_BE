package com.weiz.loanservice.command.controller.impl;

import com.weiz.loanservice.command.command.CreateLoanTypeCommand;
import com.weiz.loanservice.command.command.DeleteLoanTypeCommand;
import com.weiz.loanservice.command.command.UpdateLoanTypeCommand;
import com.weiz.loanservice.command.controller.LoanTypeController;
import com.weiz.loanservice.command.data.enums.LoanTypeStatusEnum;
import com.weiz.loanservice.command.model.LoanTypeRequest;
import com.weiz.loanservice.command.model.LoanTypeUpdateRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
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
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .interestRate(request.getInterestRate())
                .maxAmount(request.getMaxAmount())
                .maxTerm(request.getMaxTerm())
                .minAmount(request.getMinAmount())
                .minTerm(request.getMinTerm())
                .status(LoanTypeStatusEnum.ACTIVE)
                .build();

        return commandGateway.sendAndWait(command);
    }

    @Override
    public String updateLoanType(String id, LoanTypeUpdateRequest request) {

        log.info("LOAN TYPE CONTROLLER: Update loan type request...");

        // check id
        if (!Objects.equals(id, request.getId())) {
            throw new RuntimeException("Invalid ID");
        }

        // convert id
        UpdateLoanTypeCommand command = UpdateLoanTypeCommand.builder()
                .id(id)
                .name(request.getName())
                .description(request.getDescription())
                .interestRate(request.getInterestRate())
                .maxAmount(request.getMaxAmount())
                .maxTerm(request.getMaxTerm())
                .minAmount(request.getMinAmount())
                .minTerm(request.getMinTerm())
                .status(request.getStatus())
                .build();

        return commandGateway.sendAndWait(command);
    }

    @Override
    public String deleteLoanType(String id) {

        log.info("LOAN TYPE CONTROLLER: Delete loan type request...");

        DeleteLoanTypeCommand command = DeleteLoanTypeCommand.builder()
                .id(id)
                .build();

        return commandGateway.sendAndWait(command);
    }


}
