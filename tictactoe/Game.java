import java.util.Scanner;
import tsk.Board;
public class Game{
	public static void main(String[] args){
		Board board = new Board();
		
		Scanner scanner = new Scanner(System.in);

		int countCells = 0;
		while(countCells < 9 && !checkWin(board)){
			int i = scanner.nextInt();
			int j = scanner.nextInt();

			if(i >= 0 && i < 3 && j >= 0 && j < 3 && board.getCells()[i][j] == '-'){
				board.play(i, j);
				countCells++;
			}
		}

		if(checkWin(board)){
			System.out.println("You win!!");
		}else{
			System.out.println("Tie!!");
		}
	}

	public static boolean checkWin(Board board){
		char[][] cells = board.getCells();

		int checkLine      = 0;
		int checkColumn    = 0;
		int checkDiagonal1 = 0;
		int checkDiagonal2 = 0;

		char charDiagonal1 = cells[0][0];
		char charDiagonal2 = cells[0][2];

		if(charDiagonal1 == '-') charDiagonal1 = ' ';
		if(charDiagonal2 == '-') charDiagonal2 = ' ';

		for(int i = 0; i < 3 && checkLine < 3 && checkColumn < 3; i++){
			char charColumn = cells[0][i];
			char charLine   = cells[i][0];

			if(charColumn == '-') charColumn = ' ';
			if(charLine   == '-') charLine   = ' ';

			if(cells[i][i]   == charDiagonal1)   checkDiagonal1++; 
			if(cells[i][2-i] == charDiagonal2)   checkDiagonal2++; 

			for(int j = 0; j < 3; j++){
				if(cells[i][j] == charLine)   checkLine++; 
				if(cells[j][i] == charColumn) checkColumn++; 
			}
		}
		if(checkLine == 3 || checkColumn == 3 || checkDiagonal1 == 3 || checkDiagonal2 == 3){
			return true;
		}else{
			return false;
		}
	}
}
