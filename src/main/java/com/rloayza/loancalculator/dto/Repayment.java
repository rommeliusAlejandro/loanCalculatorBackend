package com.rloayza.loancalculator.dto;

import java.time.LocalDate;
import java.util.Date;

public class Repayment {

    private Integer period;
    private Double balance;
    private Double instalment;
    private Double toInterest;
    private Double toPrincipal;
    private LocalDate date;


    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getInstalment() {
        return instalment;
    }

    public void setInstalment(Double instalment) {
        this.instalment = instalment;
    }

    public Double getToInterest() {
        return toInterest;
    }

    public void setToInterest(Double toInterest) {
        this.toInterest = toInterest;
    }

    public Double getToPrincipal() {
        return toPrincipal;
    }

    public void setToPrincipal(Double toPrincipal) {
        this.toPrincipal = toPrincipal;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
