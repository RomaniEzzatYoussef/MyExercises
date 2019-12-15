package chapter12;
/**
 *
 * 09/05/2019   10:04:52 PM
 *  
 * @author Romani Ezzat
 *
 *
 * Exercise_04
 *
 */
public class Exercise_04 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try
		{
			Loan loan = new Loan(10, 30, 100000);
			loan.setAnnualInterestRate(-5);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

}

class Loan 
{
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;

	/** Default constructor */
	public Loan() 
	{
		this(2.5, 1, 1000);
	}

	/** 
	 * Construct a loan with specified annual interest rate,
	 * number of years and loan amount
	 */
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) 
	{
		if (annualInterestRate <= 0)
			throw new IllegalArgumentException("Annual interest rate must be positive.");
		if (numberOfYears <= 0)
			throw new IllegalArgumentException("Number of years must be positive.");
		if (loanAmount <= 0)
			throw new IllegalArgumentException("Loan amount must be positive.");
		
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new java.util.Date();
	}

	/** Return annualInterestRate */
	public double getAnnualInterestRate() 
	{
		return annualInterestRate;
	}

	/** Set a new annualInterestRate */
	public void setAnnualInterestRate(double annualInterestRate) 
	{
		if (annualInterestRate <= 0)
			throw new IllegalArgumentException("Annual interest rate must be positive.");
		this.annualInterestRate = annualInterestRate;
	}

	/** Return numberOfYears */
	public int getNumberOfYears() 
	{
		return numberOfYears;
	}

	/** Set a new numberOfYears */
	public void setNumberOfYears(int numberOfYears) 
	{
		if (numberOfYears <= 0)
			throw new IllegalArgumentException("Number of years must be positive.");
		this.numberOfYears = numberOfYears;
	}

	/** Return loanAmount */
	public double getLoanAmount() 
	{
		return loanAmount;
	}

	/** Set a newloanAmount */
	public void setLoanAmount(double loanAmount) 
	{
		if (loanAmount <= 0)
			throw new IllegalArgumentException("Loan amount must be positive.");
		this.loanAmount = loanAmount;
	}

	/** Find monthly payment */
	public double getMonthlyPayment() 
	{
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
		return monthlyPayment;    
	}

	/** Find total payment */
	public double getTotalPayment() 
	{
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;    
	}

	/** Return loan date */
	public java.util.Date getLoanDate() 
	{
		return loanDate;
	}
}