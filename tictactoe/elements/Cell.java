package tictactoe.elements;

public class Cell {
    private char symbol; //identifies the cell, it could be X, O or -
    private int value;

    /*  Overload constructor
        Parameters: character and a integer
    */
    public Cell(char symbol, int value) {
        this.setSymbol(symbol);
        this.setValue(value);
    }

    //Sets the cell symbol
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    //Returns the cell symbol
    public char getSymbol() {
        return this.symbol;
    }

    //Sets the value of the cell
    public void setValue(int value) {
        this.value = value;    
    }

    //Returns the cell's value
    public int getValue() {
        return this.value;
    }
}