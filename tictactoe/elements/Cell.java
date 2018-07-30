package tictactoe.elements;

public class Cell {
    private int value;

    //set the values of each type of cell
    private static final char emptySymbol     = '-';
    private static final char player1Symbol   = 'X';
    private static final char player2Symbol   = 'O';

    /*  Overload constructor
        Parameters: character and a integer
    */
    public Cell(int value) {
        this.setValue(value);
    }

    //Returns the cell symbol
    public char getSymbol() {
        char symbol = '-';
        switch(this.getValue()){
            case 1:
                symbol = player1Symbol;
                break;
            case 2:
                symbol = player2Symbol;
                break;
            default:
                symbol = emptySymbol;
                break;
        }
        return symbol;
    }

    //Sets the value of the cell
    public void setValue(int value) {
        if(value < 0)
            this.value = -1;
        else 
            this.value = 1;
    }

    //Returns the cell's value
    public int getValue() {
        return this.value;
    }
}