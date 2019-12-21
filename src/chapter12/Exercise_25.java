package chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise_25
{
    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("src/RomaniFiles/chapter_12/Exercise_24.txt");
        if (!dataFile.exists())
        {
            System.out.print("File not found, terminating program.");
            System.exit(0);
        }

        parseData(dataFile);
    }

    public static void parseData(File dataFile) throws FileNotFoundException
    {
        try (Scanner reader = new Scanner(dataFile);)
        {
            double associateSal = 0, assistantSal = 0, fullSal = 0;
            int associateCount = 0, assistantCount = 0, fullCount = 0;

            while (reader.hasNext())
            {
                String[] parseInfo = reader.nextLine().split(" ");

                if (parseInfo[2].equals("Assistant"))
                {
                    assistantSal += Double.parseDouble(parseInfo[3]);
                    assistantCount++;
                }

                else if (parseInfo[2].equals("Associate"))
                {
                    associateSal += Double.parseDouble(parseInfo[3]);
                    associateCount++;
                }
                else
                {
                    fullSal += Double.parseDouble(parseInfo[3]);
                    fullCount++;
                }
            }

            System.out.printf("%s%28s%18s\n", "Title", "Total Salary", "Average Salary");
            System.out.printf("Assistant Professor %12.2f %12.2f\n", assistantSal, (assistantSal / assistantCount));
            System.out.printf("Associate Professor %12.2f %12.2f\n", associateSal, (associateSal / associateCount));
            System.out.printf("Full Professor %17.2f %13.2f", fullSal, (fullSal / fullCount));
        }
    }
}
