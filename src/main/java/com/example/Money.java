package com.example;

import java.rmi.server.RMIClassLoader;

public class Money {
    protected int amount;

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount;
    }
}