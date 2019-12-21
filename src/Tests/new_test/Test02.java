package Tests.new_test;

public class Test02 
{
	public static void main(String[] args) 
	{
		AAA a = new AAA(10.0 , 2);
		System.out.println(a.toString());
		
		
	}
}

class B 
{
	private double radius;
	
	public B(double radius)
	{
		this.radius = radius;
	}
	
	public double getRadius() 
	{
		return radius;
	}
	
	public double getArea()
	{
		return radius * radius * Math.PI;
	}

}

class AAA extends B
{
	private double length;
	
	public AAA (double radius , double length)
	{
		super(radius);
		this.length = length;
	}
	
	@Override
	public double getArea()
	{
		return super.getArea() * length;
	}
}