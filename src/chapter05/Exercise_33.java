package chapter05;
/**
 * Perfect number
 * A positive integer is called a perfect number if it is equal to the sum of all of its positive divisors, excluding itself. 
 * For example, 6 is the first perfect number because 6 = 3 + 2 + 1. The next is 28 = 14 + 7 + 4 + 2 + 1. 
 * There are four perfect numbers less than 10,000. Write a program to find all these four numbers.
 * 
 * 30/11/2017   8:02:02 AM
 *  
 * @author roman
 *
 *
 * Exercise_33
 *
 */
public class Exercise_33 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int perfectNumber = 0;
		
		for (int i = 6; i <= 10000; i++)
		{
			for (int j = 1; j <= i / 2; j++)
				if (i % j == 0)
					perfectNumber += j;
			
			if (i == perfectNumber)
				System.out.print(i + " ");
			
			perfectNumber = 0;
		}
	}

}
