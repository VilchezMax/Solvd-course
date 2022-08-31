package com.banking.models.humans;

import java.util.Objects;

public abstract class Person {
    //ATTRIBUTES
    private String name;
    private int age;
    private int idNumber;

    //CONSTRUCTORS
    public Person() {
        this.name = "";
        this.age = 18;
        this.idNumber = (int) Math.random() * 1000000;
    }

    public Person(String name, int age, int idNumber) {
        this.name = name;
        this.age = age;
        this.idNumber = idNumber;
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

    //METHODS

    //TODO: ABSTRACT METHOD TO JUSTIFY ABSTRACT IN CLASS DECLARATION

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
