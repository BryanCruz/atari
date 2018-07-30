package tictactoe.frontend;

import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class UserInput{
  private static Scanner input = new Scanner(System.in);
	public static int readInt() throws Exception{
		int n;
		try{
			n = input.nextInt();
		}
		catch(InputMismatchException e){
			throw new Exception("Only numbers are allowed here");
		}
		finally{
			input.nextLine();
		}
		return n;
	}

	public static int readIntOption(int minOption, int maxOption){
		int option = -1;
		while(option < 0){
			try {
				option = UserInput.readInt();

				if (option < minOption || option > maxOption){
					throw new Exception("That's not a valid option");
				}
			}
			catch (Exception e) {
				option = -1;
				System.out.println("Something went wrong: " + e.getMessage());
				System.out.print("Choose a new option: ");
			}
		}
		return option;
	}


	public static String readString(){
		String read = input.nextLine();
		return read;
	}
}
