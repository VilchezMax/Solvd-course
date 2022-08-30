package com.banking.models;

public enum ClientMenu {
    CHECK_BALANCE(1),
    CREDIT(2),
    DEPOSIT(3),
    TRANSFER(4),
    EXIT(5);

    private int option;

    ClientMenu(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }
}
