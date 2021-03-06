package chapter08;

import java.util.Scanner;

/**
 * Game: connect four
 * Connect four is a two-player board game in which the players alternately drop colored disks into a seven-column, 
 * six-row vertically suspended grid, as shown below. 
 * The objective of the game is to connect four same-colored disks in a row, a column, or a diagonal before your opponent can do likewise. 
 * The program prompts two players to drop a red or yellow disk alternately. 
 * In the preceding figure, the red disk is shown in a dark color and the yellow in a light color. 
 * Whenever a disk is dropped, the program redisplays the board on the console and determines the status of the game 
 * (win, draw, or continue).
 * 
 * 11/12/2017   1:20:22 PM
 *  
 * @author roman
 *
 *
 * Exercise_20
 *
 */
public class Exercise_20 
{
	static Scanner input = new Scanner(System.in);
	static char[][] grid = new char[6][7];
	
	public static void main(String[] args) 
	{
		playConnectFour();
	}
	
	/**
	 * Plays the game connect four
	 * Ask the user to enter a red or a yellow chip
	 * Game ends when there are four same-colored disk in a row, a column, a diagonal, or a tie
	 * playersTurn == true, red players turn
	 * playersTurn == false, yellow players turn
	 * @param grid
	 */
	public static void playConnectFour()
	{
		displayGrid(grid);
		
		boolean gameOver = false;
		boolean playersTurn = true;
		
		int columnPosition = 0;
		char chipColor;
		
		while (!gameOver)
		{
			if (playersTurn)
			{
				System.out.print("Drop a red disk at column (0�6): ");
				chipColor = 'R';			
			}
			else
			{
				System.out.print("Drop a yellow disk at column (0�6): ");
				chipColor = 'Y';
			}
			
			columnPosition = input.nextInt();
			while (columnPosition < 0 || columnPosition > 6)
			{
				System.out.print("Column position must be between 0 to 6: ");
				columnPosition = input.nextInt();
			}
			
			playersTurn = !playersTurn;
			
			if (dropChip(grid, columnPosition, chipColor))
				playersTurn = !playersTurn;
			else
			{
				displayGrid(grid);
				
				if (gameStatus(grid, columnPosition, chipColor))
				{
					gameOver = true;
					System.out.print(chipColor + " won! Game Over!");
				}
				else if (checkTie(grid))
				{
					gameOver = true;
					System.out.print("It's a tie!");
				}
			}
		}
		
		input.close();
	}
	
	/**
	 * Returns true if row 0 if the grid is entirely filled
	 * 
	 * @param grid
	 * @return
	 */
	public static boolean checkTie(char[][] grid)
	{
		for (int i = 0; i < grid[0].length; i++)
			if (grid[0][i] == 0)
				return false;
		
		return true;
	}
	
	/**
	 * Returns true if four same-colored disks in a row, a column, or a diagonal is found
	 * 
	 * @param grid
	 * @param columnPosition
	 * @param chipColor
	 * @return
	 */
	public static boolean gameStatus(char[][] grid, int columnPosition, char chipColor)
	{
		int rowPosition = 0;
		
		for (int i = 0; i < grid.length; i++)
			if (grid[i][columnPosition] != 0)
			{
				rowPosition = i;
				break;
			}
		
		if (checkColumn(grid, columnPosition, chipColor, rowPosition))
			return true;
		if (checkRow(grid, columnPosition, chipColor, rowPosition))
			return true;
		if (checkMajorDiagonal(grid, columnPosition, chipColor, rowPosition))
			return true;
		if (checkMinorDiagonal(grid, columnPosition, chipColor, rowPosition))
			return true;
		
		return false;
	}
	
	/**
	 * Returns true if four same-colored disks in a minor diagonal is found
	 * 
	 * @param grid
	 * @param columnPosition
	 * @param chipColor
	 * @param rowPosition
	 * @return
	 */
	public static boolean checkMinorDiagonal(char[][] grid, int columnPosition, char chipColor, int rowPosition)
	{
		int chipCounter = 1;
		
		for (int i = rowPosition + 1, j = columnPosition - 1; i < grid.length && j >= 0; i++, j--)
			if (chipColor == grid[i][j])
				chipCounter++;			
			else
				break;
		
		if (chipCounter >= 4)
			return true;
		
		for (int i = rowPosition - 1, j = columnPosition + 1; i >= 0 && j < grid[0].length; i--, j++)
			if (chipColor == grid[i][j])
				chipCounter++;
			else
				break;
		
		if (chipCounter >= 4)
			return true;
		
		return false;
	}
	
	/**
	 * Returns true if four same-colored disks in a major diagonal is found
	 * 
	 * @param grid
	 * @param columnPosition
	 * @param chipColor
	 * @param rowPosition
	 * @return
	 */
	public static boolean checkMajorDiagonal(char[][] grid, int columnPosition, char chipColor, int rowPosition)
	{
		int chipCounter = 1;
		
		for (int i = rowPosition - 1, j = columnPosition - 1; i >= 0 && j >= 0; i--, j--)
			if (chipColor == grid[i][j])
				chipCounter++;
			else
				break;
		
		if (chipCounter >= 4)
			return true;
		
		for (int i = rowPosition + 1, j = columnPosition + 1; i < grid.length && j < grid[0].length; i++, j++)
			if (chipColor == grid[i][j])
				chipCounter++;
			else
				break;
		
		if (chipCounter >= 4)
			return true;
		
		return false;
	}
	
	/**
	 * Returns true if four same-colored disks in a rows is found
	 * 
	 * @param grid
	 * @param columnPosition
	 * @param chipColor
	 * @param rowPosition
	 * @return
	 */
	public static boolean checkRow(char[][] grid, int columnPosition, char chipColor, int rowPosition)
	{
		int chipCounter = 1;
		
		for (int i = columnPosition - 1; i >= 0; i--)
			if (chipColor == grid[rowPosition][i])
				chipCounter++;
			else
				break;
		
		if (chipCounter >= 4)
			return true;
		
		for (int i = columnPosition + 1; i < grid[0].length; i++)
			if (chipColor == grid[rowPosition][i])
				chipCounter++;
			else
				break;
		
		if (chipCounter >= 4)
			return true;

		return false;
	}
	
	/**
	 * Returns true if four same-colored disks in a column is found
	 * 
	 * @param grid
	 * @param columnPosition
	 * @param chipColor
	 * @param rowPosition
	 * @return
	 */
	public static boolean checkColumn(char[][] grid, int columnPosition, char chipColor, int rowPosition)
	{
		int chipCounter = 1;
		
		if ((rowPosition + 4) <= 6)
			for (int i = rowPosition + 1; i <= (rowPosition + 3); i++)
				if (chipColor == grid[i][columnPosition])
					chipCounter++;
				else
					break;
		if (chipCounter == 4)
			return true;
		
		return false;
	}
	
	/**
	 * Drop a chip to the bottom of the column of the grid.
	 * If column is full, ask same player to drop a chip somewhere else
	 * 
	 * @param grid
	 * @param columnPosition
	 * @param chipColor
	 */
	public static boolean dropChip(char[][] grid, int columnPosition, char chipColor)
	{
		for (int i = grid.length - 1; i >= 0; i--)
			if (grid[i][columnPosition] == 0)
			{
				grid[i][columnPosition] = chipColor;
				return false;
			}
		System.out.println("Column full, " + chipColor + " player, try again!");
		return true;
	}
	
	/**
	 * Displays the connect four grid with the yellow or red chip if there are any
	 * 
	 * @param grid
	 */
	public static void displayGrid(char[][] grid)
	{
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[i].length; j++)
				System.out.print("|" + grid[i][j]);
			System.out.println("|");
		}
		
		for (int i = 0; i < grid.length - 1; i++)
			System.out.print("---");
		System.out.println();
	}
}