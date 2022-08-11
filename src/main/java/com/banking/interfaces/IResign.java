package com.banking.interfaces;

/*
RESIGN INTERFACE: IMPLEMENTED BY PEOPLE WHO CAN RESIGN
WHY NOT EXTENDED FROM PERSON? BECAUSE EVERYONE BUT GUESTS CAN RESIGN, BE IT WORKERS OR CLIENTS.
 */
public interface IResign {
    public static void resign(){}
}
