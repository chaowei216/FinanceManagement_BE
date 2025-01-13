package com.weiz.loanservice.command.event;

import com.weiz.loanservice.command.data.LoanType;
import com.weiz.loanservice.command.data.enums.LoanStatusEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class LoanCreatedEvent {

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

}
