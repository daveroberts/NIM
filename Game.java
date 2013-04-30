public class Game{

//  declare variables
private int row1;
private int row2;
private int row3;
private String player1;
private String player2;
private boolean firstPlayersTurn = false; //  whose turn is it

  //  main constructor
  public Game()
  {
    row1 = 5;
    row2 = 7;
    row3 = 9;
    firstPlayersTurn = true;
  }

  public void setPlayer1(String p1){
    player1 = p1;
  }

  public void setPlayer2(String p2){
    player2 = p2;
  }

  //  returns a value for pegs in any row
  public int getRowX(int x)
  {
    if (x == 1)
      return row1;
    else if (x == 2)
      return row2;
    else if (x == 3)
      return row3;
    else return -1;
  }

  //  Selects the row to remove pegs from
  public boolean validRow(int rowPick)
  {
    if (rowPick > 0 && rowPick < 4)
    {
      if (getRowX(rowPick) > 0)
        return true;
      else
        return false;
    }
    else
      return false;
  }

  //  Checks if number of pegs removed is valid
  public boolean selectPegs(int rowPick, int pegPick)
  {
     if (pegPick > 0 && pegPick <= getRowX(rowPick))
        return true;
     else
        return false;
  }

  //  Removes the pegs
  public void removePegs(int row, int pegs)
  {
    if (row == 1)
      row1 = row1 - pegs;
    else if (row == 2)
      row2 = row2 - pegs;
    else
      row3 = row3 - pegs;
  }

  //  Check for winning
  public boolean isFinished()
  {
    return (row1 == 0 && row2 == 0 && row3 == 0);
  }

  public boolean myTurn()
  {
    return firstPlayersTurn;
  }
  public void switchTurn()
  {
    if (firstPlayersTurn == true)
    {
      firstPlayersTurn = false;
    }
    else
      firstPlayersTurn = true;
  }
  public String currentPlayer(){
    if (firstPlayersTurn){ return player1; }
    else { return player2; }
  }
  public void displayPegs()
  {
    System.out.print("Row 1 - ");
    if (row1 != 0)
    {
      for (int i = 0; i < row1; i++)
      {
       System.out.print("*");
      }
      System.out.print("(" + row1 + ")");
    }
    else
    {
      System.out.print("Empty");
    }
    System.out.println();
    System.out.print("Row 2 - ");
    if (row2 != 0)
    {
      for (int i = 0; i < row2; i++)
      {
        System.out.print("*");
      }
      System.out.print("(" + row2 + ")");
    }
    else
    {
      System.out.print("Empty");
    }
    System.out.println();
    System.out.print("Row 3 - ");
    if (row3 != 0)
    {
      for (int i = 0; i < row3; i++)
      {
        System.out.print("*");
      }
      System.out.print("(" + row3 + ")");
    }
    else
    {
      System.out.print("Empty");
    }
    System.out.println();
  }
}
