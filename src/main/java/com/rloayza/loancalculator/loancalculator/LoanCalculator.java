package com.rloayza.loancalculator.loancalculator;

import com.rloayza.loancalculator.dto.Repayment;
import com.rloayza.loancalculator.util.EMICalculator;

import java.util.List;

public abstract class LoanCalculator {

    protected final Double getInstalment(Double principalAmount, Integer loanPeriod, Double interestRate) {

        EMICalculator calculator = new EMICalculator();
        return calculator.calculate(principalAmount, loanPeriod, interestRate);

    }

    public abstract List<Repayment> calculateLoan(Double principalAmount, Integer loanPeriod, Double interestRate);
}
