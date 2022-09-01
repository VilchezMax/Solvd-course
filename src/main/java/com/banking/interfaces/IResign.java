package com.banking.interfaces;

/*
 * RESIGN INTERFACE: IMPLEMENTED BY PEOPLE WHO CAN RESIGN
 * WHY NOT EXTENDED FROM PERSON? BECAUSE EVERYONE BUT GUESTS CAN RESIGN, BE IT WORKERS OR CLIENTS.
 */

import com.banking.exceptions.UnregisteredException;

@FunctionalInterface
public interface IResign {
    public void resign() throws UnregisteredException;
}
