package Tests.utilities;

import java.util.Arrays;

public class ExternalSort 
{
	private String fileLocation;
	
	public ExternalSort()
	{
		this ("src/Text_Files/Chapter_23/dataSet.dat");
	}
	
	public ExternalSort(String fileLocation)
	{
		this.fileLocation = fileLocation;
	}
	
	public void sort() throws IOException
	{
		int[] list = new int[1000000];
		
		try 
		{
			DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(fileLocation)));
			DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src/Text_Files/Chapter_23/sortedSet.dat")));
			
			int i = 0;
			for (; input.available() > 0 && i < list.length; i++)
				list[i] = input.readInt();
			
			Arrays.sort(list, 0, i);
			
			for (int j = 0; j < i; j++)
				output.writeInt(list[j]);
				
			input.close();
			output.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
	}
}
