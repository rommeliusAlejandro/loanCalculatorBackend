package com.rloayza.loancalculator.loancalculator;

import com.rloayza.loancalculator.dto.LoanDetailsDTO;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

@Component
public class LoanCalculatorFactory {

    public Class<? extends LoanCalculator> getLoanCalculator(Double principal, Integer loanLife) throws InvalidParameterException {

        if(1 <= principal.doubleValue() && principal.doubleValue() <= 1000) {
            return DecliningLoanCalculator.class;
        }

        if(1001 <= principal.doubleValue() && principal.doubleValue() <= 100000) {
            if(36 == loanLife.intValue()){
                return DecliningLoanCalculator.class;
            }

            return FlatLoanCalculator.class;
        }

        throw new InvalidParameterException("Principal and number of periods are not valid");
    }

    public LoanDetailsDTO getLoanDetails(Double principal, Integer loanLife) {
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

        throw new InvalidParameterException("Principal and number of periods are not valid");
    }
}
