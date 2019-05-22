package com.rloayza.loancalculator.loancalculator;

import com.rloayza.loancalculator.dto.LoanDetailsResponseDTO;
import com.rloayza.loancalculator.dto.Repayment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlatLoanCalculator extends LoanCalculator {

    @Override
    public LoanDetailsResponseDTO calculateLoan(Double principalAmount, Integer loanPeriod, Double interestRate) {

        List<Repayment> schedule = new ArrayList<>();

        Double interestValue = interestRate/100d;
        Double balance = principalAmount;

        Double forInterest = principalAmount * interestValue;
        Double forPrincipal = principalAmount/loanPeriod;
        Double instalment = forInterest + forPrincipal;

        for(int i=1; i<=loanPeriod; i++) {

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

        Map<String, Double> summary = new HashMap<>();
        summary.put("totalInstalment", instalment * loanPeriod);
        summary.put("totalInterest", forInterest * loanPeriod);
        summary.put("totalToPrincipal", forPrincipal * loanPeriod);

        LoanDetailsResponseDTO responseDTO = new LoanDetailsResponseDTO();
        responseDTO.setSchedule(schedule);
        responseDTO.setEmi(instalment);
        responseDTO.setSummary(summary);

        return responseDTO;
    }
}
