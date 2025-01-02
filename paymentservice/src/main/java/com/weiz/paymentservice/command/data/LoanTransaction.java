package com.weiz.paymentservice.command.data;

import com.weiz.paymentservice.command.data.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(
        name = "loan_transactions"
)
public class LoanTransaction extends AbstractEntity<String> {

    @Id
    @Column(name = "loan_transaction_id")
    String id;

    @Column(
            name = "loan_schedule_id",
            nullable = false
    )
    String loanScheduleId;

    @Column(
            name = "amount_paid",
            nullable = false
    )
    Long amountPaid;

    @Column(
            name = "payment_date",
            nullable = false
    )
    LocalDateTime paymentDate;

    @ManyToOne(
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "payment_method_id")
    PaymentMethod paymentMethod;

    @Column(
            name = "status",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    TransactionStatus status;
}
