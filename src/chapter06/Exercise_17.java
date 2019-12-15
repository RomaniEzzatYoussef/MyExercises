package chapter06;

import java.util.Random;
import java.util.Scanner;

/**
 * Display matrix of 0s and 1s
 * Write a method that displays an n-by-n matrix using the following header: 
 * public static void printMatrix(int n) 
 * Each element is 0 or 1, which is generated randomly. 
 * Write a test program that prompts the user to enter n and displays an n-by-n matrix.
 *
 * 02/12/2017   8:21:58 AM
 *  
 * @author roman
 *
 *
 * Exercise_17
 *
 */
public class Exercise_17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number less than 10: ");
		printMatrix(input.nextInt());
		
		input.close();
	}
	
	/**
	 * Displays an n-by-n matrix
	 * Display matrix of 0s and 1s
	 * 
	 * @param n
	 */
	public static void printMatrix(int n) 
	{
		Random binaryNum = new Random();
		
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
				System.out.print(binaryNum.nextInt(2) + " ");
			System.out.println();
		}
	}
}
