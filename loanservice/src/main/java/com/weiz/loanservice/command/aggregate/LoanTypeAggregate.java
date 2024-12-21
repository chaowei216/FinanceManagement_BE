package com.weiz.loanservice.command.aggregate;

import com.weiz.loanservice.command.command.CreateLoanTypeCommand;
import com.weiz.loanservice.command.data.enums.LoanTypeStatusEnum;
import com.weiz.loanservice.command.event.LoanTypeCreatedEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Aggregate
@NoArgsConstructor
@Getter
@Setter
public class LoanTypeAggregate {

    @AggregateIdentifier
    String name;
    Long minAmount;
    Long maxAmount;
    Double interestRate;
    Integer minTerm;
    Integer maxTerm;
    String description;
    LoanTypeStatusEnum status;

    @CommandHandler
    public LoanTypeAggregate(CreateLoanTypeCommand command) {

        // init event
        LoanTypeCreatedEvent event = new LoanTypeCreatedEvent();

        // map properties
        BeanUtils.copyProperties(command, event);

        // publish event
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(LoanTypeCreatedEvent event) {
        this.name = event.getName();
        this.minAmount = event.getMinAmount();
        this.maxAmount = event.getMaxAmount();
        this.interestRate = event.getInterestRate();
        this.minTerm = event.getMinTerm();
        this.maxTerm = event.getMaxTerm();
        this.description = event.getDescription();
        this.status = event.getStatus();
    }
}
