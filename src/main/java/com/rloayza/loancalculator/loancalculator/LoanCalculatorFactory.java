package com.rloayza.loancalculator.loancalculator;

import com.rloayza.loancalculator.dto.LoanDetailsDTO;
import com.rloayza.loancalculator.exceptions.LoanCalculatorException;
import org.springframework.stereotype.Component;

@Component
public class LoanCalculatorFactory {

    public Class<? extends LoanCalculator> getLoanCalculator(Double principal, Integer loanLife) throws LoanCalculatorException {

        if(1 <= principal.doubleValue() && principal.doubleValue() <= 1000) {
            return DecliningLoanCalculator.class;
        }

        if(1001 <= principal.doubleValue() && principal.doubleValue() <= 100000) {
            if(36 == loanLife.intValue()){
                return DecliningLoanCalculator.class;
            }

            return FlatLoanCalculator.class;
        }

        throw new LoanCalculatorException("Principal and number of periods are not valid");
    }

    public LoanDetailsDTO getLoanDetails(Double principal, Integer loanLife) throws LoanCalculatorException {
        LoanDetailsDTO loanDetails = new LoanDetailsDTO();
        loanDetails.setPrimary(principal);
        loanDetails.setLoanLife(loanLife);

        if(1 <= principal.doubleValue() && principal.doubleValue() <= 1000) {
            loanDetails.setAnualInterestRate(10d);
            return loanDetails;
        }

        if(1001 <= principal.doubleValue() && principal.doubleValue() <= 100000) {
            loanDetails.setAnualInterestRate(5d);
            return loanDetails;
        }

        throw new LoanCalculatorException("Principal and number of periods are not valid");
    }
}
