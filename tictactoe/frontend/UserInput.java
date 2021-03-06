package tictactoe.frontend;

import java.util.Scanner;
import java.util.InputMismatchException;
import tictactoe.exceptions.UserInputException;

// Read and validate the user's inputs
public abstract class UserInput {
  private static Scanner input = new Scanner(System.in);

  // Read an integer in a line
  public static int readInt() throws UserInputException {
    int n = -1;
    try {
      n = input.nextInt();
    } catch (InputMismatchException e) {
      throw new UserInputException("Only numbers are allowed here");
    } finally {
      input.nextLine();
    }
    return n;
  }

  // Read an integer in a range [minOption, maxOption]
  public static int readIntOption(int minOption, int maxOption) {
    return UserInput.readIntOption(minOption, maxOption, "option");
  }

  // Read an integer in a range [minOption, maxOption]
  public static int readIntOption(int minOption, int maxOption, String optionName) {
    int option = -1;
    while (option < 0) {
      try {
        option = UserInput.readInt();

        if (option < minOption || option > maxOption) {
          throw new UserInputException("That option is not inside the valid range", optionName);
        }
      } catch (UserInputException e) {
        option = -1;
        System.out.print(e.getMessage());
      }
    }
    return option;
  }

  // Read a String in a line
  public static String readString() {
    String read = input.nextLine();
    return read;
  }
}
