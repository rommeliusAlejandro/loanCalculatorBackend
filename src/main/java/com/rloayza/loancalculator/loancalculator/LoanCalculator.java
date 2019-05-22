package com.rloayza.loancalculator.loancalculator;

import com.rloayza.loancalculator.dto.LoanDetailsResponseDTO;
import com.rloayza.loancalculator.util.EMICalculator;

public abstract class LoanCalculator {

    protected final Double getInstalment(Double principalAmount, Integer loanPeriod, Double interestRate) {

        EMICalculator calculator = new EMICalculator();
        return calculator.calculate(principalAmount, loanPeriod, interestRate);

    }

    public abstract LoanDetailsResponseDTO calculateLoan(Double principalAmount, Integer loanPeriod, Double interestRate);
}
