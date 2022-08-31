package com.banking.models;

public enum Tier {

    SOLVD(1, 5, 400, 3),
    GOLDEN(2, 3, 300, 2),
    SILVER(3, 1, 200, 1),
    BRONZE(4, 0, 100, 1),
    GUEST(5, 0, 0, 0);

    private int priority;
    private int interestDisc;
    private int maxScore;
    private int maxAmountMultiplier;

    private Tier(int priority, int interestDisc, int maxScore, int maxAmountMultiplier) {
        this.priority = priority;
        this.interestDisc = interestDisc;
        this.maxScore = maxScore;
        this.maxAmountMultiplier = maxAmountMultiplier;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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
