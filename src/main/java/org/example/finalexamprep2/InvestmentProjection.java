package org.example.finalexamprep2;

public class InvestmentProjection {
    private int year;
    private double startingAmount;
    private double interest;
    private double endingBalance;

    public InvestmentProjection(int year, double startingAmount, double interest, double endingBalance) {
        this.year = year;
        this.startingAmount = startingAmount;
        this.interest = interest;
        this.endingBalance = endingBalance;
    }

    public int getYear() {
        return year;
    }

    public double getStartingAmount() {
        return startingAmount;
    }

    public double getInterest() {
        return interest;
    }

    public double getEndingBalance() {
        return endingBalance;
    }
}
