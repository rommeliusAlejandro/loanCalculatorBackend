package com.rloayza.loancalculator.dto;

import java.util.List;
import java.util.Map;

public class LoanDetailsResponseDTO extends ResponseDTO {

    private List<Repayment> schedule;
    private Double emi;
    private Map<String, Double> summary;

    public List<Repayment> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Repayment> schedule) {
        this.schedule = schedule;
    }

    public Double getEmi() {
        return emi;
    }

    public void setEmi(Double emi) {
        this.emi = emi;
    }

    public Map<String, Double> getSummary() {
        return summary;
    }

    public void setSummary(Map<String, Double> summary) {
        this.summary = summary;
    }
}
