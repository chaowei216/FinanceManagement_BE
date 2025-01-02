package com.weiz.loanscheduleservice.command.data.repository;

import com.weiz.loanscheduleservice.command.data.LoanSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanScheduleRepository extends JpaRepository<LoanSchedule, String> {
}
