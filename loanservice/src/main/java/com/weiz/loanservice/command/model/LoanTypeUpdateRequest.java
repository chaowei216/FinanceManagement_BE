package com.weiz.loanservice.command.model;

import com.weiz.loanservice.command.data.enums.LoanTypeStatusEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanTypeUpdateRequest {

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
