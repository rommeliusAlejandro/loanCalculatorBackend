package com.rloayza.loancalculator.dto;

public class LoanDetailsDTO {

    private Double primary;

    private Integer loanLife;

    private Double anualInterestRate;

    public Double getPrimary() {
        return primary;
    }

    public void setPrimary(Double primary) {
        this.primary = primary;
    }

    public Integer getLoanLife() {
        return loanLife;
    }

    public void setLoanLife(Integer loanLife) {
        this.loanLife = loanLife;
    }

    public Double getAnualInterestRate() {
        return anualInterestRate;
    }

    public void setAnualInterestRate(Double anualInterestRate) {
        this.anualInterestRate = anualInterestRate;
    }
}
