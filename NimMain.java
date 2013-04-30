/**
 * <p>Title: Nim Game</p>
 * <p>Date: April 30th, 2013</p>
 *
 * @author David Roberts
 * @version 0.4
 */

import java.io.*;

public class NimMain
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Game nim = new Game();
    System.out.println("Welcome to the game of Nim");
    System.out.println("Enter the name of player 1");
    nim.setPlayer1(br.readLine());
    System.out.println("Enter the name of player 2");
    nim.setPlayer2(br.readLine());
    while (!nim.isFinished())
    {
      System.out.println(nim.currentPlayer() + ", it is your turn");
      //  Selects a valid row
      nim.displayPegs();
      boolean validRow = false;
      int row = 0;
      while (!validRow)
      {
        System.out.print("Which row do you want to pick from? ");
        row = getInt(br);
        if (!nim.validRow(row)){
          System.err.println("This is not a valid row");
        } else
          validRow = true;
      }
      //  Pick the number of Pegs to remove
      nim.displayPegs();
      boolean validPegs = false;
      int pegs = 0;
      while (!validPegs) {
        System.out.println("How many pegs do you want to take from this row?");
        pegs = getInt(br);
        validPegs = nim.selectPegs(row, pegs);
        if (!validPegs) {
          System.err.println("Incorrect value, try again");
          nim.displayPegs();
        }
      }

      //  Removes the pegs
      nim.removePegs(row,pegs);

      //  Check for winning
      if (nim.isFinished()){
        System.out.println("A winner is you " + nim.currentPlayer());
        System.exit(0);
      }
      nim.switchTurn();
      System.out.println(); //  Add spaces
      System.out.println(); //  Add spaces
    }
  }
  public static int getInt(BufferedReader br) throws IOException {
    while (true)
    {
      String strInt = br.readLine();
      try {
        int value = Integer.parseInt(strInt);
        return value;
      } catch (NumberFormatException nfe){
        System.err.println("You must enter a number");
      }
    }
  }
}
