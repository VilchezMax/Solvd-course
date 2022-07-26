package homework22.models;

public enum Tier{
    bronze(0,100),
    silver(1,200),
    golden(3,300),
    solvd(5,400);

    private int interestDisc;
    private int maxScore;

    private Tier(int interestDisc, int maxScore) {
        this.interestDisc = interestDisc;
        this.maxScore = maxScore;
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

}
