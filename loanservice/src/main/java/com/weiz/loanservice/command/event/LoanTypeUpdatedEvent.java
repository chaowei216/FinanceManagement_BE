package com.weiz.loanservice.command.event;

import com.weiz.loanservice.command.data.enums.LoanTypeStatusEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanTypeUpdatedEvent {

    String id;
    String name;
    Long minAmount;
    Long maxAmount;
    Double interestRate;
    Integer minTerm;
    Integer maxTerm;
    String description;
    LoanTypeStatusEnum status;
}
