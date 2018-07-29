package tictactoe.elements;

public class CellNotEmptyException extends Exception{
	public CellNotEmptyException(){
        super("This cell has already been played");
    }
}
