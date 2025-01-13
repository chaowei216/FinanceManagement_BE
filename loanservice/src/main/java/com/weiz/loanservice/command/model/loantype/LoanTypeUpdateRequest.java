package com.weiz.loanservice.command.model.loantype;

import com.weiz.loanservice.command.data.enums.LoanTypeStatusEnum;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanTypeUpdateRequest {

    String id;
    @NotBlank(message = "name is mandatory")
    @Size(min = 2, max = 50, message = "name must be between 2 and 30 characters")
    String name;

    @Min(value = 0)
    Long minAmount;

    @Min(value = 0)
    Long maxAmount;

    @DecimalMin(value = "0.01", message = "rate must be 0.01 at least")
    Double interestRate;

    @Min(value = 1, message = "min term must be 1 at least")
    Integer minTerm;

    @NotNull
    Integer maxTerm;

    @NotBlank(message = "description must not be blank")
    String description;

    @NotNull
    LoanTypeStatusEnum status;
}
