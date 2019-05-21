package com.rloayza.loancalculator.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public final class EMICalculator {

    public final double calculate(double principalAmount, int loanDuration, double interestRate) {
        double instalment;
        double interestRateValue = interestRate / 100d;
        double interestPow = Math.pow(interestRateValue+1, loanDuration);

        instalment = principalAmount * ((interestRateValue*interestPow)/(interestPow-1));

        BigDecimal bigDecimal = new BigDecimal(instalment).setScale(2, RoundingMode.HALF_UP);

        return bigDecimal.doubleValue();
    }
}
