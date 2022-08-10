package com.banking.models;

import java.util.Objects;

public class Minor extends Person {
    //ATTRIBUTES
    private int studentID;
    private String school;

    //CONSTRUCTORS
    public Minor(String name, int age, int idNumber, int studentID, String school) {
        super(name, age, idNumber);
        this.studentID = studentID;
        this.school = school;
    }

    //SETTERS & GETTERS
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    //METHODS


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minor minor = (Minor) o;
        return studentID == minor.studentID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID);
    }
}
