package com.rloayza.loancalculator.rest;

import com.rloayza.loancalculator.dto.LoanDetailsDTO;
import com.rloayza.loancalculator.dto.Repayment;
import com.rloayza.loancalculator.loancalculator.LoanCalculator;
import com.rloayza.loancalculator.loancalculator.LoanCalculatorFactory;
import com.rloayza.loancalculator.util.EMICalculator;
import com.rloayza.loancalculator.dto.CalculatorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class LoanCalculatorController {

    @Autowired
    private LoanCalculatorFactory factory;

    @RequestMapping(
            value = "/calculateLoan",
            method = RequestMethod.POST
    )
    public List<Repayment> calculateLoan(@RequestBody CalculatorDTO calculatorDTO) {

        LoanCalculator loanCalculator = factory.getLoanCalculator(
                calculatorDTO.getPrincipalAmount(),
                calculatorDTO.getLoanLife()
        );

        System.out.println(loanCalculator.getClass());

        LoanDetailsDTO detailsDTO = factory.getLoanDetails(
                calculatorDTO.getPrincipalAmount(),
                calculatorDTO.getLoanLife()
        );

        Double monthlyInterestRate = detailsDTO.getAnualInterestRate()/12d;
        return loanCalculator.calculateLoan(
                detailsDTO.getPrimary(),
                detailsDTO.getLoanLife(),
                monthlyInterestRate
        );
    }
}
