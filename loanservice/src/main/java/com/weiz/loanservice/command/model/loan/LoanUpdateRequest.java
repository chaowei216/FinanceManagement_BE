package com.weiz.loanservice.command.model.loan;

import com.weiz.loanservice.command.data.enums.LoanStatusEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanUpdateRequest {

    @NotNull
    String id;

    @NotNull
    LoanStatusEnum status;
}
