package homework2.models;

import java.util.Objects;

public class Adult extends Person{
    //ATTRIBUTES
    private String occupation;
    private int creditScore;

    //CONSTRUCTORS
    public Adult(){
        super();
        this.setName("");
        this.setAge(18);
        this.setIdNumber((int) Math.random()*100000000);
        this.occupation="Unemployed";
        if(this.getOccupation().equals("Unemployed")){
            this.creditScore=0;
        } else {
            this.creditScore=10;
        }
    }
    public Adult(String name, int age, int idNumber, String occupation, int creditScore) {
        super(name, age, idNumber);
        this.occupation = occupation;
        this.creditScore = creditScore;
    }

    //SETTERS & GETTERS

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }


    //METHODS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adult adult = (Adult) o;
        return creditScore == adult.creditScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditScore);
    }
}
