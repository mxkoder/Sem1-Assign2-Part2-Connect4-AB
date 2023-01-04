package org.example.Counters;

public class Counter {

    private int counterNumber;
    private Character counterSymbol;

    /**
     * Counter object and associated methods
     * <p>Stores the counter symbol (X or O) and the integer value of the counter for the 2D gameGrid array</p>
     * @param counterNumber integer - counter integer for 2D gameGrid array
     * @param counterSymbol Character - used to display the counter in the gameGri when printed
     */
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
