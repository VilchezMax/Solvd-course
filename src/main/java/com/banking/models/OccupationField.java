package com.banking.models;

public enum OccupationField {
    UNEMPLOYED(-50),
    HEALTH(10),
    IT(10),
    EDUCATION(10),
    BUSINESS(20),
    ART_CULTURE(5),
    COMMUNICATIONS(10),
    SCIENCE(10),
    AGRICULTURE(10),
    MANUFACTURE(10);

    private int creditScoreModifier;

    OccupationField(int creditScoreModifier) {
        this.creditScoreModifier = creditScoreModifier;
    }

    public int getCreditScoreModifier() {
        return creditScoreModifier;
    }

    public void setCreditScoreModifier(int creditScoreModifier) {
        this.creditScoreModifier = creditScoreModifier;
    }
}

