package chapter10;

import java.util.Random;

/**
 ** The Queue class
 * Design a class named Queue for storing integers. 
 * Like a stack, a queue holds elements. 
 * In a stack, the elements are retrieved in a last-in first-out fashion. 
 * In a queue, the elements are retrieved in a first-in first-out fashion. The class contains: 
 * An int[] data field named elements that stores the int values in the queue.
 * A data field named size that stores the number of elements in the queue.
 * A constructor that creates a Queue object with default capacity 8.
 * The method enqueue(int v) that adds v into the queue.
 * The method dequeue() that removes and returns the element from the queue. 
 * The method empty() that returns true if the queue is empty.
 * The method getSize() that returns the size of the queue.
 * Implement the class with the initial array size set to 8. 
 * The array size will be doubled once the number of the elements exceeds the size. 
 * After an element is removed from the beginning of the array, you need to shift all elements in the array one position the left. 
 * Write a test program that adds 20 numbers from 1 to 20 into the queue and removes these numbers and displays them.
 * 
 * 21/04/2019   7:29:39 AM
 *  
 * @author Romani Ezzat
 *
 *
 * Exercise_10
 *
 */
public class Exercise_10 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Queue queue = new Queue();
		
		storeNumbers(queue , 20);
		
		queue.dequeueFirstInFirstOutFashion();
		
		//removeNumbers(queue);
	}
	
	public static void removeNumbers(Queue queue)
	{
		while(!queue.isEmpty())
			queue.dequeueFirstInFirstOutFashion();
			//System.out.print(queue.dequeue() + " ");
			
	}
	
	public static void storeNumbers(Queue queue , int size)
	{
		Random random = new Random();
		
		for (int i = 0; i < size; i++)
		{
			int num = random.nextInt(20) + 1;
			System.out.printf("%4d",num);
			queue.enqueue(num);
		}
		
		System.out.println();
	}

}
