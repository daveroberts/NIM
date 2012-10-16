/**
 * <p>Title: Nim Game</p>
 * <p>Date: January 20th, 2002</p>
 *
 * @author David Roberts
 * @version 0.3
 */
public class NimMain
{
  public static void main(String[] args)
  {
    boolean winner = false;
    String playerA;
    String playerB;
    int rowPick;  //  Row number picked
    int pegsInRow;  //  Actual Number of pegs in row
    int pegPick;  // Users pick of number of pegs
    SimpleInput g = new SimpleInput();
    Game nim = new Game();
    System.out.println("Welcome to the game of Nim");
    System.out.println("Enter the name of player 1");
    playerA = g.nextWord();
    System.out.println("Enter the name of player 2");
    playerB = g.nextWord();
    while (winner == false)
    {
      if (nim.myTurn() == true)
      {
        System.out.println(playerA + ", it is your turn");
      }
      else
      {
        System.out.println(playerB + ", it is your turn");
      }

      //  Selects a valid row
      nim.displayPegs();
      System.out.println("Which row do you want to pick from");
      rowPick = g.nextInt();
      while (!nim.selectRow(rowPick))
      {
          System.out.println("Incorrect value, try again");
          nim.displayPegs();
          System.out.println("Which row do you want to pick from");
          rowPick = g.nextInt();
      }

      //  Pick the number of Pegs to remove
      nim.displayPegs();
      System.out.println("How many pegs do you want to take from this row?");
      pegPick = g.nextInt();
      pegsInRow = nim.getRowX(rowPick);
      while (!nim.selectPegs(rowPick, pegPick))
      {
        System.out.println("Incorrect value, try again");
        nim.displayPegs();
        System.out.println("How many pegs do you want to take from this row?");
        pegPick = g.nextInt();
      }

      //  Removes the pegs
      nim.removePegs(rowPick,pegPick);

      //  Check for winning
      winner = nim.checkWinning();
      if (winner == true)
      {
        if (nim.myTurn() == true)
        {
          System.out.println("A winner is you " + playerA + "!");
        }
        else
        {
          System.out.println("A winner is you " + playerB + "!");
        }
      }
      else
      {
        nim.switchTurn();
        System.out.println(); //  Add spaces
        System.out.println(); //  Add spaces
      }
    }
  }
}