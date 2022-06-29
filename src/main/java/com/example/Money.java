package com.example;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.rmi.server.RMIClassLoader;

public class Money implements Expresssion {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency(){
        return currency;
    }


    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    public static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount && this.currency == money.currency;
    }

    @Override
    public Money reduce(String to){
        return this;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Money times(int multiplier){
        return new Money(amount * multiplier, this.currency);
    }

    public Expresssion plus(Money added){
        return new Sum(this, added);
    }
}
