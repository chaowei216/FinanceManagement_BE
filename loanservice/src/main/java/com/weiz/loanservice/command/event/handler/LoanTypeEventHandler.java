package com.weiz.loanservice.command.event.handler;

import com.weiz.loanservice.command.data.LoanType;
import com.weiz.loanservice.command.data.enums.LoanTypeStatusEnum;
import com.weiz.loanservice.command.data.repository.LoanTypeRepository;
import com.weiz.loanservice.command.event.LoanTypeCreatedEvent;
import com.weiz.loanservice.command.event.LoanTypeDeletedEvent;
import com.weiz.loanservice.command.event.LoanTypeUpdatedEvent;
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
public class LoanTypeEventHandler {

    LoanTypeRepository loanTypeRepository;

    @EventHandler
    @Transactional
    public void on(LoanTypeCreatedEvent event) {

        LoanType loanType = new LoanType();

        // map properties
        BeanUtils.copyProperties(event, loanType);

        // set status
        loanType.setStatus(LoanTypeStatusEnum.ACTIVE);

        // save to db
        loanTypeRepository.save(loanType);
    }

    @EventHandler
    @Transactional
    public void on(LoanTypeUpdatedEvent event) {

        // get instance in db
        final var loanType = loanTypeRepository
                .findById(event.getId())
                .orElseThrow(RuntimeException::new);

        // map properties
        BeanUtils.copyProperties(event, loanType);

        // save to db
        loanTypeRepository.save(loanType);
    }

    @EventHandler
    @Transactional
    public void on(LoanTypeDeletedEvent event) {

        // get instance in db
        final var loanType = loanTypeRepository
                .findById(event.getId())
                .orElseThrow(RuntimeException::new);

        // set status
        loanType.setStatus(LoanTypeStatusEnum.INACTIVE);

        // save to db
        loanTypeRepository.save(loanType);
    }
}
