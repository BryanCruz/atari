package tictactoe.elements;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import tictactoe.backend.Engine;
import tictactoe.elements.Board;

public class IA extends Player {

  private Board board = Board.getInstance();

  private int difficulty;

  private Random random;

  public IA(int difficulty, int number) {
    super(number);
    this.setDifficulty(difficulty);
    random = new Random();
  }

  // Set the AI's difficulty
  public void setDifficulty(int difficulty) {
    this.difficulty = difficulty;
  }

  // Returns the AI's difficulty
  public int getDifficulty() {
    return this.difficulty;
  }

  // Return the AI's "name"
  @Override
  public String getName(){
    return "Computer " + this.getNumber();
  }

  // Controls what strategy the AI will utilize to make a choice
  @Override
  public int[] chooseCell() {
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch(Exception e) {
      //TODO: find how to handle this
      System.out.println("handling exception");
    }

    int iaDifficulty = this.getDifficulty();
    //If difficulty == 1, it plays randomly
    if (iaDifficulty == 1) {
      return makeRandomChoice();
    } else {
      Player testPlayer = new IA(9, this.getNumber() == 1 ? 2 : 1);
      if (iaDifficulty == 2) {
        //if difficulty == 2, plays randomly 50% of the time and strategically in the other 50%
        double option = random.nextDouble();
        if (option < 0.5) {
          return makeRandomChoice();
        } else {
          return makeStrategicChoice(this.getDifficulty(), true, this, testPlayer);
        }
      } else if (iaDifficulty == 3) {
        //if difficulty == 2, plays estrategically (but still can lose)
        return makeStrategicChoice(this.getDifficulty(), true, this, testPlayer);
      } else {
        //else, it will always tie
        return makeStrategicChoice(9, true, this, testPlayer);
      }
    }
  }

  // Returns a random position which the AI will play
  public int[] makeRandomChoice() {
    int x, y;
    do {
      x = Math.abs(random.nextInt()) % board.getBoardSize();
      y = Math.abs(random.nextInt()) % board.getBoardSize();
    } while (!Engine.checkEmptyCell(board.getCell(x, y)));
    return (new int[] {x, y});
  }

  /*   Recursive algorithm that utilizes minMax strategy to decide which position the AI will play:
    Heuristc funtion utilized:
      Win = +1;
      Lose = -1;
      Tie = 0;
    On our turn we maximize the score, on opponent's turn we minimize.
    The difficulty is a parameter that controls how many times the AI will "lookAhead", i.e.,
        how many plays it will simulate to decide the best play. At difficulty=9, the AI
        simulutes all the possible moves, therefore it'll never loose.
  */
  public int[] makeStrategicChoice(int difficulty, boolean maximize, Player currentPlayer,
      Player opponent) {
    // A vector that stores the row, column and score of a play
    int[] choice = new int[] {-1, -1, 0};

    // A list that stores all the  best possible choices for the next move
    ArrayList<int[]> possibleChoices = new ArrayList<>();

    //Checks for a win, tie or loss
    int score = Engine.checkWin();  //Checks

    //base case
    if (Engine.checkFullBoard() || difficulty == 0 || score != 0 ) {
      if (score == this.getNumber()) {
        // If the score is equal to our(AI) number that means that it won
        choice[2] = 1;
      } else if (score == 0) {
        // If it's zero, we got a tie
        choice[2] = 0;
      } else {
        //If it's different, the opponent won
        choice[2] = -1;
      }
    } else {
      // Decides if we maximize or minimize the next moves
      int bestScore = maximize ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      // Check the board for empty cells
      for (int i = 0; i < board.getBoardSize(); i++) {
        for (int j = 0; j < board.getBoardSize(); j++) {
          // If cell's empty
          if (Engine.checkEmptyCell(board.getCell(i, j))) {
            Engine.play(currentPlayer, new int[] {i, j});

            score = makeStrategicChoice(difficulty - 1, !maximize, opponent, currentPlayer)[2];

            if (score == bestScore) {
              possibleChoices.add(new int[] {i, j, bestScore});
            } else if ((score < bestScore) ^ maximize) {
              //We utilize a XOR to decide if the score we got is grater or lower than the bestScore
              bestScore = score;
              possibleChoices.clear();
              possibleChoices.add(new int[] {i, j, bestScore});
            }
            //Undo the play
            Engine.setEmptyCell(board.getCell(i, j));
          }
        }
      }
    }
    //Takes a random best choice vector
    if (!possibleChoices.isEmpty()) {
      choice = possibleChoices.get(random.nextInt(possibleChoices.size()));
    }

    return choice;
  }
}
