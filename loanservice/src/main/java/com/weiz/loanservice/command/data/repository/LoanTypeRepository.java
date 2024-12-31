package com.weiz.loanservice.command.data.repository;

import com.weiz.loanservice.command.data.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTypeRepository extends JpaRepository<LoanType, String> {
}
