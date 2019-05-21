package com.rloayza.loancalculator.dto;

import java.math.BigDecimal;

public class CalculatorDTO {

    private Double principalAmount;
    private Integer loanLife;

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
}
