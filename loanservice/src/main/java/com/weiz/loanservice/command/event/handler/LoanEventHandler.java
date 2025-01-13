package com.weiz.loanservice.command.event.handler;

import com.weiz.loanservice.command.data.Loan;
import com.weiz.loanservice.command.data.enums.LoanStatusEnum;
import com.weiz.loanservice.command.data.repository.LoanRepository;
import com.weiz.loanservice.command.data.repository.LoanTypeRepository;
import com.weiz.loanservice.command.event.LoanCreatedEvent;
import com.weiz.loanservice.command.event.LoanDeletedEvent;
import com.weiz.loanservice.command.event.LoanUpdatedEvent;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
@Transactional
public class LoanEventHandler {

    LoanRepository loanRepository;
    LoanTypeRepository loanTypeRepository;

    @EventHandler
    public void on(LoanCreatedEvent event) {

        // check loan type
        final var loanType = loanTypeRepository
                .findById(event.getLoanTypeId())
                .orElseThrow(() -> new RuntimeException("Loan type not found"));

        // init entity
        Loan loan = new Loan();

        // map data
        BeanUtils.copyProperties(event, loan);

        // assign loan type
        loan.setLoanType(loanType);

        // save to db
        loanRepository.save(loan);
    }

    @EventHandler
    public void on(LoanUpdatedEvent event) {

        // check loan type
        final var loan = loanRepository.findById(event.getId())
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        // update entity
        loan.setStatus(event.getStatus());

        // save to db
        loanRepository.save(loan);
    }

    @EventHandler
    public void on(LoanDeletedEvent event) {

        // check loan type
        final var loan = loanRepository.findById(event.getId())
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        // update entity
        loan.setStatus(LoanStatusEnum.PAID);

        // save to db
        loanRepository.save(loan);
    }
}
