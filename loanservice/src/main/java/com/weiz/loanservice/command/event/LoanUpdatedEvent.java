package com.weiz.loanservice.command.event;

import com.weiz.loanservice.command.data.enums.LoanStatusEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class LoanUpdatedEvent {

    String id;
    LoanStatusEnum status;
}
