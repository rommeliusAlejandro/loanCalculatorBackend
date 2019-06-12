package com.rloayza.loancalculator;

import com.rloayza.loancalculator.dto.LoanDetailsResponseDTO;
import com.rloayza.loancalculator.exceptions.LoanCalculatorException;
import com.rloayza.loancalculator.loancalculator.DecliningLoanCalculator;
import com.rloayza.loancalculator.loancalculator.FlatLoanCalculator;
import com.rloayza.loancalculator.loancalculator.LoanCalculatorFactory;
import com.rloayza.loancalculator.loancalculator.LoanDetailsValidator;
import com.rloayza.loancalculator.util.EMICalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoanCalculatorApplicationTests {

    @Autowired
    private LoanCalculatorFactory loanCalculatorFactory;

    @Autowired
    private DecliningLoanCalculator decliningLoanCalculator;

    @Autowired
    private FlatLoanCalculator flatLoanCalculator;

    @Autowired
    private LoanDetailsValidator loanDetailsValidator;

	@Test
	public void contextLoads() {
	}

    @DisplayName("Testing Calculator factory")
    @Test
    void testCalculatorFactory() throws LoanCalculatorException {
	    Assertions.assertEquals(
                DecliningLoanCalculator.class,
                loanCalculatorFactory.getLoanCalculator(true)
        );

        Assertions.assertEquals(
                FlatLoanCalculator.class,
                loanCalculatorFactory.getLoanCalculator(false)
        );
    }

	@DisplayName("Testing EMI Calculator")
    @Test
    void testEmiCalculator() {
        EMICalculator calculator = new EMICalculator();
	    Assertions.assertEquals(
                87.98518195529934d,
                calculator.calculate(1001, 12, 0.83)
        );

        Assertions.assertEquals(
                134934.9967755467d,
                calculator.calculate(10000000d, 120, 0.875)
        );

        Assertions.assertEquals(
                4843.084774686315d,
                calculator.calculate(751680d, 300, 0.5)
        );
    }

    @DisplayName("Calculating loan: declining")
    @Test
    void  testDecliningLoanCalculator(){

        LoanDetailsResponseDTO responseDTO = decliningLoanCalculator.calculateLoan(1000d, 12, 0.42d);
        Assertions.assertEquals(12, responseDTO.getSchedule().size());
    }

    @DisplayName("Calculating loan: flat")
    @Test
    void  testFlatLoanCalculator(){
        LoanDetailsResponseDTO responseDTO = flatLoanCalculator.calculateLoan(1000d, 12, 0.42d);
        Assertions.assertEquals(12, responseDTO.getSchedule().size());
    }

}
