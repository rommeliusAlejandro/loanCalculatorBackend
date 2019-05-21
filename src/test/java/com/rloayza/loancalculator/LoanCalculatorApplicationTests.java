package com.rloayza.loancalculator;

import com.rloayza.loancalculator.loancalculator.DecliningLoanCalculator;
import com.rloayza.loancalculator.loancalculator.FlatLoanCalculator;
import com.rloayza.loancalculator.util.EMICalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoanCalculatorApplicationTests {

	@Test
	public void contextLoads() {
	}

	@DisplayName("Testing EMI Calculator")
    @Test
    void testEmiCalculator() {
        EMICalculator calculator = new EMICalculator();
	    Assertions.assertEquals(
                87.59d,
                calculator.calculate(1001, 12, 0.83)
        );

        Assertions.assertEquals(
                134935.00d,
                calculator.calculate(10000000d, 120, 0.875)
        );

        Assertions.assertEquals(
                4843.08d,
                calculator.calculate(751680d, 300, 0.5)
        );
    }

    @DisplayName("Calculating loan: declining")
    @Test
    void  testDecliningLoanCalculator(){
        DecliningLoanCalculator loanCalculator = new DecliningLoanCalculator();

        //Assertions.assertTrue(loanCalculator.calculateLoan(751680d, 300, 0.5));

    }

    @DisplayName("Calculating loan: flat")
    @Test
    void  testFlatLoanCalculator(){
        FlatLoanCalculator loanCalculator = new FlatLoanCalculator();

        //Assertions.assertTrue(loanCalculator.calculateLoan(751680d, 300, 0.5));

    }

}
