package com.weiz.loanservice.command.data;

import com.weiz.loanservice.command.data.enums.LoanTypeStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "loan_types",
        indexes = {
                @Index(
                        columnList = "loan_type_name", unique = true)
        }
)
public class LoanType extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_type_id")
    Integer id;

    @Column(
            name = "loan_type_name",
            nullable = false,
            length = 50
    )
    String name;

    @Column(
            name = "min_amount",
            nullable = false
    )
    Double minAmount;

    @Column(
            name = "max_amount",
            nullable = false
    )
    Double maxAmount;

    @Column(
            name = "interest_rate",
            nullable = false
    )
    Double interestRate;

    @Column(
            name = "min_term",
            nullable = false
    )
    Integer minTerm;

    @Column(
            name = "max_term",
            nullable = false
    )
    Integer maxTerm;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "status",
            nullable = false
    )
    LoanTypeStatusEnum status;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "text"
    )
    String description;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "loanType"
    )
    List<Loan> loans;
}
