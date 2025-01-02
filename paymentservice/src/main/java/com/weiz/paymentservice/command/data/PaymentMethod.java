package com.weiz.paymentservice.command.data;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(
        name = "payment_methods"
)
public class PaymentMethod extends AbstractEntity<String> {

    @Id
    @Column(name = "payment_method_id")
    String id;

    @Column(
            name = "method_name",
            nullable = false,
            length = 50
    )
    String methodName;

    @Column(
            name = "details",
            nullable = false,
            columnDefinition = "text"
    )
    String details;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "paymentMethod"
    )
    List<LoanTransaction> loanTransactions;
}
