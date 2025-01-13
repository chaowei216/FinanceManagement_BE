package com.weiz.loanservice.command.data.repository;

import com.weiz.loanservice.command.data.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, String> {
}
