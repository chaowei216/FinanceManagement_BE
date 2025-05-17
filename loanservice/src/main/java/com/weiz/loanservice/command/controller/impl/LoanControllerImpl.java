package com.weiz.loanservice.command.controller.impl;

import com.weiz.commonservice.services.KafkaService;
import com.weiz.loanservice.command.command.loans.CreateLoanCommand;
import com.weiz.loanservice.command.command.loans.DeleteLoanCommand;
import com.weiz.loanservice.command.command.loans.UpdateLoanCommand;
import com.weiz.loanservice.command.controller.LoanController;
import com.weiz.loanservice.command.data.enums.LoanStatusEnum;
import com.weiz.loanservice.command.model.loan.LoanCreateRequest;
import com.weiz.loanservice.command.model.loan.LoanUpdateRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class LoanControllerImpl implements LoanController {

    CommandGateway commandGateway;

    KafkaService kafkaService;

    @Override
    public String addLoans(LoanCreateRequest request) {

        log.info("LOAN CONTROLLER: Add loan request...");

        CreateLoanCommand command = CreateLoanCommand.builder()
                .id(UUID.randomUUID().toString())
                .amount(request.getAmount())
                .endDate(request.getEndDate())
                .loanTypeId(request.getLoanTypeId())
                .installmentAmount(request.getInstallmentAmount())
                .interestRate(request.getInterestRate())
                .startDate(request.getStartDate())
                .term(request.getTerm())
                .status(LoanStatusEnum.PENDING)
                .userId(request.getUserId())
                .build();

        return commandGateway.sendAndWait(command);
    }

    @Override
    public String updateLoan(String id, LoanUpdateRequest request) {

        log.info("LOAN CONTROLLER: Update loan request...");

        // check id
        if (!id.equals(request.getId())) {
            throw new RuntimeException("Invalid ID");
        }

        UpdateLoanCommand command = UpdateLoanCommand.builder()
                .id(id)
                .status(request.getStatus())
                .build();

        return commandGateway.sendAndWait(command);
    }

    @Override
    public String deleteLoanType(String id) {

        log.info("LOAN CONTROLLER: Delete loan request...");

        DeleteLoanCommand command = DeleteLoanCommand.builder()
                .id(id)
                .build();

        return commandGateway.sendAndWait(command);
    }

    @Override
    public void sendMessage(String message) {
        kafkaService.sendMessage("test", message);
    }
}
