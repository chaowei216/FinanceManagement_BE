package com.weiz.loanservice.query.model;

import com.weiz.loanservice.command.data.LoanType;
import com.weiz.loanservice.command.data.enums.LoanStatusEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanResponseDTO {

    String id;
    Long amount;
    Double interestRate;
    LocalDate startDate;
    LocalDate endDate;
    LoanStatusEnum status;
    int term;
    Long installmentAmount;
    String loanTypeName;
    String userId;
}
