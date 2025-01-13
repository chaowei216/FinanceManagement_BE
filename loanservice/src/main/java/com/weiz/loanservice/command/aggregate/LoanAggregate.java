package com.weiz.loanservice.command.aggregate;

import com.weiz.loanservice.command.command.loans.CreateLoanCommand;
import com.weiz.loanservice.command.command.loans.DeleteLoanCommand;
import com.weiz.loanservice.command.command.loans.UpdateLoanCommand;
import com.weiz.loanservice.command.command.loantypes.CreateLoanTypeCommand;
import com.weiz.loanservice.command.data.LoanType;
import com.weiz.loanservice.command.data.enums.LoanStatusEnum;
import com.weiz.loanservice.command.event.LoanCreatedEvent;
import com.weiz.loanservice.command.event.LoanDeletedEvent;
import com.weiz.loanservice.command.event.LoanTypeCreatedEvent;
import com.weiz.loanservice.command.event.LoanUpdatedEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Aggregate
@NoArgsConstructor
@Getter
@Setter
public class LoanAggregate {

    @AggregateIdentifier
    String id;
    Long amount;
    Double interestRate;
    LocalDate startDate;
    LocalDate endDate;
    LoanStatusEnum status;
    int term;
    Long installmentAmount;
    String loanTypeId;
    String userId;

    @CommandHandler
    public LoanAggregate(CreateLoanCommand command) {

        // init event
        LoanCreatedEvent event = new LoanCreatedEvent();

        // map properties
        BeanUtils.copyProperties(command, event);

        // publish event
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateLoanCommand command) {

        // init event
        LoanUpdatedEvent event = new LoanUpdatedEvent();

        // map properties
        BeanUtils.copyProperties(command, event);

        // publish event
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteLoanCommand command) {

        // init event
        LoanDeletedEvent event = new LoanDeletedEvent();

        // map properties
        BeanUtils.copyProperties(command, event);

        // publish event
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(LoanCreatedEvent event) {
        this.id = event.getId();
        this.amount = event.getAmount();
        this.interestRate = event.getInterestRate();
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.status = event.getStatus();
        this.term = event.getTerm();
        this.installmentAmount = event.getInstallmentAmount();
        this.loanTypeId = event.getLoanTypeId();
        this.userId = event.getUserId();
    }

    @EventSourcingHandler
    public void on(LoanUpdatedEvent event) {
        this.status = event.getStatus();
    }

    @EventSourcingHandler
    public void on(LoanDeletedEvent event) {
        this.status = LoanStatusEnum.PAID;
    }
}
