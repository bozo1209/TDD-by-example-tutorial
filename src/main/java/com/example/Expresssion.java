package com.example;

public interface Expresssion {
    Money reduce(Bank bank, String to);
    Expresssion plus(Expresssion addend);
    Expresssion times(int multiplier);
}
