package com.weiz.loanservice.command.event.handler;

import com.weiz.loanservice.command.data.LoanType;
import com.weiz.loanservice.command.data.enums.LoanTypeStatusEnum;
import com.weiz.loanservice.command.data.repository.LoanTypeRepository;
import com.weiz.loanservice.command.event.LoanTypeCreatedEvent;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class LoanTypeEventHandler {

    LoanTypeRepository loanTypeRepository;

    @EventHandler
    public void handle(LoanTypeCreatedEvent event) {
        LoanType loanType = new LoanType();

        // map properties
        BeanUtils.copyProperties(event, loanType);

        // set status
        loanType.setStatus(LoanTypeStatusEnum.ACTIVE);

        // save to db
        loanTypeRepository.save(loanType);
    }
}
