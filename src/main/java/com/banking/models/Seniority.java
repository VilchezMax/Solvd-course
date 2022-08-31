package com.banking.models;

public enum Seniority {
    PRINCIPAL(10),
    SENIOR(5),
    SEMI_SENIOR(3),
    JUNIOR(1),
    TRAINEE(1);

    private int creditScoreModifier;

    private Seniority(int creditScoreModifier) {
        this.creditScoreModifier = creditScoreModifier;
    }

    public int getCreditScoreModifier() {
        return creditScoreModifier;
    }

    public void setCreditScoreModifier(int creditScoreModifier) {
        this.creditScoreModifier = creditScoreModifier;
    }

}
