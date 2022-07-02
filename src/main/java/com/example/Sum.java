package com.example;

public class Sum implements Expresssion {
    Expresssion augmend;
    Expresssion addmend;

    public Sum(Expresssion augmend, Expresssion addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String to){
        int amount = augmend.reduce(bank, to).amount + addmend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expresssion plus(Expresssion addend) {
        return new Sum(this, addmend);
    }

    @Override
    public Expresssion times(int multiplier) {
        return new Sum(augmend.times(multiplier), addmend.times(multiplier));
    }
}
