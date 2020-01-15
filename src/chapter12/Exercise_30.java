package chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise_30
{
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.print("Enter the name of the file: ");
        File fileName = new File("src/Files/chapter_12/Exercise_30.txt");

        if (!fileName.exists())
        {
            System.out.print("File does not exist, terminating program.");
            System.exit(0);
        }

        int[] letterCount = new int[52];

        countLetter(fileName, letterCount);
        displayCount(letterCount);

    }

    public static void countLetter(File fileName, int[] letterCount) throws FileNotFoundException
    {
        try (Scanner reader = new Scanner(fileName);)
        {
            while (reader.hasNext())
            {
                String fileLine = reader.nextLine();

                for (int i = 0; i < fileLine.length(); i++)
                    if (Character.isAlphabetic(fileLine.charAt(i)))
                        if (fileLine.charAt(i) <= 90)
                            letterCount[fileLine.charAt(i) - 65]++;
                        else if (fileLine.charAt(i) <= 122)
                            letterCount[fileLine.charAt(i) - 71]++;
            }
        }
    }

    public static void displayCount(int [] letterCount)
    {
        for (int i = 0; i < 26; i++)
            System.out.println((char)(i + 'A') + "'s is " + letterCount[i]);

        for (int i = 26; i < 52; i++)
            System.out.println((char)(i + 71) + "'s is " + letterCount[i]);
    }
}

