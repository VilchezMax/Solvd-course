package com.banking.models.humans;

import com.banking.interfaces.ISignUp;
import com.banking.models.Bank;
import com.banking.models.OccupationField;
import com.banking.models.Seniority;

import java.util.Objects;

public abstract class Person implements ISignUp {
    //ATTRIBUTES
    private String name;
    private int age;
    private int idNumber;
    private OccupationField occupation;
    private Seniority jobSeniority;
    private int creditScore;

    //CONSTRUCTORS
    public Person() {
        this.name = "";
        this.age = 18;
        this.idNumber = (int) Math.random() * 1000000;
        this.occupation = OccupationField.UNEMPLOYED;
        this.jobSeniority = null;
        if (this.occupation.equals(OccupationField.UNEMPLOYED)) {
            this.creditScore = 0;
        } else {
            this.creditScore = 10;
        }
    }

    public Person(String name, int age, int idNumber, OccupationField occupation, Seniority jobSeniority, int creditScore) {
        this.name = name;
        this.age = age;
        this.idNumber = idNumber;
        this.occupation = occupation;
        if (!this.occupation.equals(OccupationField.UNEMPLOYED)) {
            this.creditScore = creditScore;
            this.jobSeniority = jobSeniority;
        } else {
            this.creditScore = 0;
            this.jobSeniority = null;
        }
    }

    //SETTERS & GETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public OccupationField getOccupation() {
        return occupation;
    }

    public void setOccupation(OccupationField occupation) {
        this.occupation = occupation;
    }

    public Seniority getJobSeniority() {
        return jobSeniority;
    }

    public void setJobSeniority(Seniority jobSeniority) {
        this.jobSeniority = jobSeniority;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    //METHODS

    //TODO: ABSTRACT METHOD TO JUSTIFY ABSTRACT IN CLASS DECLARATION
    @Override
    public void signUp(Bank bank) {
        bank.signingUp(this);
    }

    @Override
    public String toString() {
        return "Person {" +
                "Name= " + this.name + '\n' +
                "Age= " + this.age + '\n' +
                "ID= " + this.idNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return idNumber == person.idNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber);
    }
}
