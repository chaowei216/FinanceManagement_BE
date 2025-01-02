package com.weiz.loanscheduleservice.command.data;

import com.weiz.loanscheduleservice.command.data.enums.ScheduleEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "loan_schedules",
        indexes = {
                @Index(
                        columnList = "loan_id", unique = true
                )
        }
)
public class LoanSchedule extends AbstractEntity<String> {

    @Id
    @Column(name = "loan_schedule_id")
    String id;

    @Column(
            name = "loan_id",
            nullable = false,
            unique = true
    )
    String loanId;

    @Column(
            name = "transaction_id",
            unique = true
    )
    String transactionId;

    @Column(
            name = "payment_due_date",
            nullable = false
    )
    LocalDate paymentDueDate;

    @Column(
            name = "payment_amount",
            nullable = false
    )
    Long paymentAmount;

    @Column(
            name = "actual_amount",
            nullable = false
    )
    Long actualAmount;

    @Column(
            name = "status",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    ScheduleEnum status;

    @Override
    public String getId() {
        return id;
    }
}
