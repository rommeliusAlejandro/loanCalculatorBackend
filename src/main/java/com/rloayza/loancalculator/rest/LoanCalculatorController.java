package com.rloayza.loancalculator.rest;

import com.rloayza.loancalculator.dto.CalculatorDTO;
import com.rloayza.loancalculator.dto.LoanDetailsDTO;
import com.rloayza.loancalculator.dto.LoanDetailsResponseDTO;
import com.rloayza.loancalculator.dto.ResponseDTO;
import com.rloayza.loancalculator.exceptions.LoanCalculatorException;
import com.rloayza.loancalculator.loancalculator.LoanCalculator;
import com.rloayza.loancalculator.loancalculator.LoanCalculatorFactory;
import com.rloayza.loancalculator.loancalculator.LoanDetailsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoanCalculatorController {

    @Autowired
    private LoanCalculatorFactory factory;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private LoanDetailsValidator loanDetailsValidator;

    @RequestMapping(
            value = "/calculateLoan",
            method = RequestMethod.POST
    )
    public ResponseDTO calculateLoan(@RequestBody CalculatorDTO calculatorDTO) {

        try {

            Class<? extends LoanCalculator> calculatorClass = factory.getLoanCalculator(
                    calculatorDTO.getDecliningInterest()
            );

            LoanCalculator loanCalculator = applicationContext.getBean(calculatorClass);

            LoanDetailsDTO detailsDTO = new LoanDetailsDTO();
            detailsDTO.setAnualInterestRate(calculatorDTO.getInterestRate());
            detailsDTO.setLoanLife(calculatorDTO.getLoanLife());
            detailsDTO.setPrimary(calculatorDTO.getPrincipalAmount());

            Double monthlyInterestRate = detailsDTO.getAnualInterestRate() / 12d;

            LoanDetailsResponseDTO responseDTO;
            responseDTO = loanCalculator.calculateLoan(
                    detailsDTO.getPrimary(),
                    detailsDTO.getLoanLife(),
                    monthlyInterestRate
            );

            responseDTO.setStatusCode(200);

            return responseDTO;

        } catch (LoanCalculatorException e) {

            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatusCode(500);
            responseDTO.setMessage(e.getMessage());
            return responseDTO;

        }
    }
}
