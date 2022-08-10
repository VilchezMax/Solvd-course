package com.banking.models;

public abstract class Person {
    //ATTRIBUTES
    private String name;
    private int age;
    private int idNumber;

    //CONSTRUCTORS
    public Person(){
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
    @Override
    public String toString() {
        return  "Person {" +
                "Name= " + this.name + '\n' +
                "Age= " + this.age + '\n' +
                "ID= " + this.idNumber +
                '}';
    }
}
