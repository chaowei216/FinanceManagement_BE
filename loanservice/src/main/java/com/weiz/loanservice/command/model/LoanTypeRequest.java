package com.weiz.loanservice.command.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanTypeRequest {

    String name;
    Long minAmount;
    Long maxAmount;
    Double interestRate;
    Integer minTerm;
    Integer maxTerm;
    String description;
}
