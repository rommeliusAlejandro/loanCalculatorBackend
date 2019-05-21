package com.rloayza.loancalculator;

import com.rloayza.loancalculator.dto.Repayment;
import com.rloayza.loancalculator.loancalculator.DecliningLoanCalculator;
import com.rloayza.loancalculator.loancalculator.FlatLoanCalculator;
import com.rloayza.loancalculator.loancalculator.LoanCalculatorFactory;
import com.rloayza.loancalculator.util.EMICalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LoanCalculatorApplicationTests {

    @Autowired
    private LoanCalculatorFactory loanCalculatorFactory;

    @Autowired
    private DecliningLoanCalculator decliningLoanCalculator;

    @Autowired
    private FlatLoanCalculator flatLoanCalculator;

	@Test
	public void contextLoads() {
	}

    @DisplayName("Testing Calculator factory")
    @Test
    void testCalculatorFactory() {
	    Assertions.assertEquals(
                DecliningLoanCalculator.class,
                loanCalculatorFactory.getLoanCalculator(1000d, 12)
        );

        Assertions.assertEquals(
                DecliningLoanCalculator.class,
                loanCalculatorFactory.getLoanCalculator(1001d, 36)
        );

        Assertions.assertEquals(
                FlatLoanCalculator.class,
                loanCalculatorFactory.getLoanCalculator(1001d, 12)
        );
    }

	@DisplayName("Testing EMI Calculator")
    @Test
    void testEmiCalculator() {
        EMICalculator calculator = new EMICalculator();
	    Assertions.assertEquals(
                87.99d,
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

        List<Repayment> schedule = decliningLoanCalculator.calculateLoan(1000d, 12, 0.42d);
        Assertions.assertEquals(12, schedule.size());
    }

    @DisplayName("Calculating loan: flat")
    @Test
    void  testFlatLoanCalculator(){
        List<Repayment> schedule = flatLoanCalculator.calculateLoan(1000d, 12, 0.42d);
        Assertions.assertEquals(12, schedule.size());

    }

}
