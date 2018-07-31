package tictactoe.elements;

public abstract class Player implements IPlayer{
  private int number;

  public Player(int number){
    this.setNumber(number);
  }

  public final void setNumber(int number){
    // tictactoe has at maximum 2 players
    if(number <= 1) number = 1;
    else            number = 2;
    
    this.number = number;
  }

  public int getNumber(){
    return this.number;
  }
}
