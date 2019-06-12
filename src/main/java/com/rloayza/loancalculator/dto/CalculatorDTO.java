package com.rloayza.loancalculator.dto;

import java.math.BigDecimal;

public class CalculatorDTO {

    private Double principalAmount;
    private Integer loanLife;
    private Double interestRate;
    private Boolean decliningInterest;

    public Double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(Double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public Integer getLoanLife() {
        return loanLife;
    }

    public void setLoanLife(Integer loanLife) {
        this.loanLife = loanLife;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Boolean getDecliningInterest() {
        return decliningInterest;
    }

    public void setDecliningInterest(Boolean decliningInterest) {
        this.decliningInterest = decliningInterest;
    }
}
