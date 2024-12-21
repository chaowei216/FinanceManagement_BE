package com.weiz.loanservice.command.data;

import com.weiz.loanservice.command.data.enums.LoanScheduleStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan_schedules")
public class LoanSchedule extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "loan_schedule_id")
    UUID id;

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

    @Enumerated(EnumType.STRING)
    @Column(
            name = "status",
            nullable = false
    )
    LoanScheduleStatusEnum status;

    @ManyToOne(
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "loan_id", nullable = false)
    Loan loan;
}
