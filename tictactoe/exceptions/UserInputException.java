package tictactoe.exceptions;

public class UserInputException extends Exception {
    private String choice;

    public UserInputException(String message, String choice){
        super(message);
        this.choice = choice;
    }

    public UserInputException(String message){
        this(message, "option");
    }

    private void setChoice(String choice){
        this.choice = choice;
    }

    private String getChoice(){
        return this.choice;
    }

    @Override
    public String getMessage(){
        return "Something went wrong: " + super.getMessage() + "\nChoose a valid " + this.getChoice() + ": ";
    }
}