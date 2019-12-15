package chapter12;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class Exercise_23
{
    public static void main(String[] args)
    {
        try
        {
            URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
            Scanner readUrl = new Scanner(url.openStream());

            int total = 0, numCount = 0;

            while (readUrl.hasNext())
            {
                total += readUrl.nextInt();
                numCount++;
            }

            readUrl.close();
            System.out.print("Total: " + total
                    + "\nAverage: " + (total / numCount));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}

