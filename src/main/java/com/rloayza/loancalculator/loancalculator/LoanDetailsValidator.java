package com.rloayza.loancalculator.loancalculator;

import com.rloayza.loancalculator.exceptions.LoanCalculatorException;
import org.springframework.stereotype.Component;

@Component
public class LoanDetailsValidator {

    public void validate(Double principal, Integer loanDuration) throws LoanCalculatorException {

        if(null == principal) {
            throw new LoanCalculatorException("Principal can not be null");
        }

        if(null == loanDuration) {
            throw new LoanCalculatorException("Loan periods can not be null");
        }

        if(1 > principal.doubleValue()) {
            throw  new LoanCalculatorException("Principal amount can not be lesser than 1");
        }

        if(100000 < principal.doubleValue()) {
            throw  new LoanCalculatorException("Principal amount can not be greater than 100000");
        }

        if(12 != loanDuration.intValue() && 36 != loanDuration.intValue()) {
            throw  new LoanCalculatorException("Loan duration should either 12 or 36 months");
        }
    }
}
