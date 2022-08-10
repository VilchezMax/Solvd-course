package com.banking.models;

public enum Tier {
    BRONZE(0, 100, 2),
    SILVER(1, 200, 3),
    GOLDEN(3, 300, 5),
    SOLVD(5, 400, 10);

    private int interestDisc;
    private int maxScore;
    private int maxAmountMultiplier;

    private Tier(int interestDisc, int maxScore, int maxAmountMultiplier) {
        this.interestDisc = interestDisc;
        this.maxScore = maxScore;
        this.maxAmountMultiplier = maxAmountMultiplier;
    }

    public int getInterestDisc() {
        return interestDisc;
    }

    public void setInterestDisc(int interestDisc) {
        this.interestDisc = interestDisc;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public int getMaxAmountMultiplier() {
        return maxAmountMultiplier;
    }

    public void setMaxAmountMultiplier(int maxAmountMultiplier) {
        this.maxAmountMultiplier = maxAmountMultiplier;
    }
}
