package com.rloayza.loancalculator.loancalculator;

import com.rloayza.loancalculator.dto.Repayment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DecliningLoanCalculator extends LoanCalculator {

    @Override
    public List<Repayment> calculateLoan(Double principalAmount, Integer loanPeriod, Double interestRate) {

        List<Repayment> schedule = new ArrayList<>();

        Double instalment = getInstalment(principalAmount, loanPeriod, interestRate);
        Double interestValue = interestRate/100d;
        Double balance = principalAmount;

        for(int i=1; i<=loanPeriod; i++) {
            double forInterest = balance * interestValue;
            double forPrincipal = instalment - forInterest;

            Repayment item = new Repayment();
            item.setPeriod(i);
            item.setBalance(balance);
            item.setInstalment(instalment);
            item.setToInterest(forInterest);
            item.setToPrincipal(forPrincipal);
            item.setDate(LocalDate.now().plusMonths(i));

            schedule.add(item);

            balance -= forPrincipal;
        }

        return schedule;
    }
}
