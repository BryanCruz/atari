package tictactoe.frontend;

import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class UserInput{
	private static Scanner input = new Scanner(System.in);

	// read n integer inputs in a line
	public static int[] readInt(int n) throws Exception{
		int[] numbersRead = new int[n];
		try{
			for(int i = 0; i < n; i++){
				numbersRead[i] = input.nextInt();
			}
		}
		catch(InputMismatchException e){
			throw new Exception("Only numbers are allowed here");
		}
		finally{
			input.nextLine();
		}
		return numbersRead;
	}

	// read a integer in a line
	public static int readInt() throws Exception{
		int[] numberRead = UserInput.readInt(1);
		return numberRead[0];
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
