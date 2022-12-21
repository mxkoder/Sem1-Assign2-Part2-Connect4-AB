package org.example.Counters;

public class Counter {

    private int counterNumber;

    private Character counterSymbol;

    public Counter (int counterNumber, Character counterSymbol){

        this.counterNumber = counterNumber;
        this.counterSymbol = counterSymbol;
    }

    public int getCounterNumber () {
        return counterNumber;
    }

    public Character getCounterSymbol () {
        return counterSymbol;
    }

    public static Counter counter1X () {
        Counter counter1X = new Counter(1, 'X');
        return counter1X;
    }

    public static Counter counter2O () {
        Counter counter2O = new Counter(2, 'O');
        return counter2O;
    }
}
