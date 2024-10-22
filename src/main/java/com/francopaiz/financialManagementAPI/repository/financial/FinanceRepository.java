package com.francopaiz.financialManagementAPI.repository.financial;

import com.francopaiz.financialManagementAPI.model.FinancialSummary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends MongoRepository<FinancialSummary, String> {


}