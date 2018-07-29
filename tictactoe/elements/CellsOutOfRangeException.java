public class CellsOutOfRangeException extends Exception{
    public CellsOutOfRangeException(){
        super("This cell doesn't exist in the board");
    }
}