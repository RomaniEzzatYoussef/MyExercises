package chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Exercise_24
{
    public static void main(String[] args)
    {
        File dataFile = new File("src/RomaniFiles/chapter_12/Exercise_24.txt");
        if (!dataFile.exists())
        {
            System.out.println("File does not exist, generating file...");
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter dataset size: ");
        try {
            generateDataSet(dataFile, input.nextInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        input.close();
    }

    public static void generateDataSet(File dataFile, int size) throws FileNotFoundException
    {
        try (PrintWriter writer = new PrintWriter(dataFile))
        {
            for (int i = 1; i <= size; i++)
                writer.print("FirstName" + i + " LastName" + i + " " + getRankSalary() + "\n");
        }
    }

    public static String getRankSalary()
    {
        Random randNum = new Random();
        int position = randNum.nextInt(3);

        if (position == 0)
            return ("Assistant " + String.format("%10.2f", (50000 + Math.random() * 30000)));
        else if (position == 1)
            return ("Associate " + String.format("%10.2f", (60000 + Math.random() * 45000)));
        else
            return ("Full " + String.format("%10.2f", (70000 + Math.random() * 60000)));
    }
}
