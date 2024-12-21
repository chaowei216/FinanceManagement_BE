package com.weiz.loanservice.command.data;

import com.weiz.loanservice.command.data.enums.LoanStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loans")
public class Loan extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "loan_id")
    UUID id;

    @Column(
            name = "loan_amount",
            nullable = false
    )
    Long amount;

    @Column(
            name = "interest_rate",
            nullable = false
    )
    Long interestRate;

    @Column(
            name = "loan_date",
            nullable = false,
            updatable = false
    )
    LocalDate startDate;

    @Column(
            name = "due_date",
            nullable = false
    )
    LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "status",
            nullable = false
    )
    LoanStatusEnum status;

    @Column(
            name = "loan_term",
            nullable = false
    )
    int term;

    @Column(
            name = "installment_amount",
            nullable = false
    )
    Long installmentAmount;

    @ManyToOne(
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "loan_type_id", nullable = false)
    LoanType loanType;

    @OneToMany(
            mappedBy = "loan",
            cascade = CascadeType.ALL
    )
    List<LoanSchedule> loanSchedules;
}
