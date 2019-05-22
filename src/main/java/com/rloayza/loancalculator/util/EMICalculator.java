package com.rloayza.loancalculator.util;

public final class EMICalculator {

    public final double calculate(double principalAmount, int loanDuration, double interestRate) {
        double instalment;
        double interestRateValue = interestRate / 100d;
        double interestPow = Math.pow(interestRateValue+1, loanDuration);

        instalment = principalAmount * ((interestRateValue*interestPow)/(interestPow-1));

        return instalment;
    }
}
