package com.mini.bank.domain.repository;

import com.mini.bank.domain.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication,Long> {
}
