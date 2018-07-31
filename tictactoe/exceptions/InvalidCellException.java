package tictactoe.exceptions;

import tictactoe.exceptions.UserInputException;

public class InvalidCellException extends UserInputException {
    public InvalidCellException(String message) {
        super(message, "cell");
    }
}
