package chapter12;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise_22
{
    public static void main(String[] args)
    {
        String filepath = "E:\\work\\IntelliJ IDEA Projects\\Exercises\\RomaniFiles\\chapter_12\\Exercise_21.txt";

        File currentDir = new File(filepath);
        System.out.println("Directory name: " + currentDir.getName());

        if (!currentDir.exists())
        {
            System.out.println("Current directory " + filepath + " does not exist");
            System.exit(1);
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter oldString:");
        String oldString = input.next();

        System.out.print("Enter newString:");
        String newString = input.next();

        if (currentDir.isFile())
            replaceInAFile(currentDir, oldString , newString);
        else
        {
            File[] files = currentDir.listFiles();

            for (int i = 0; i < files.length; i++)
                if (files[i].isFile())
                    replaceInAFile(files[i], oldString, newString);
        }
    }

    private static void replaceInAFile(File sourceFile, String oldStr, String newStr)
    {
        StringBuilder sb = new StringBuilder();

        try
        {
            try (Scanner input = new Scanner(sourceFile);)
            {
                while (input.hasNext())
                {
                    String s1 = input.next();
                    String s2 = s1.replaceAll(oldStr, newStr);
                    sb.append(s2 + "\n");

                    if (s1 != s2)
                    {
                        System.out.println("OldLine: "+s1 + "\nNewLine: " + s2 + "\n");
                    }
                }
            }

            try (PrintWriter output = new PrintWriter(sourceFile);)
            {
                output.printf("%s\n", sb.toString());
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
