package chapter12;

import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

public class ReadURLFile
{
    public static void main(String[] args)
    {
        File aciiCodeFile = new File("src/Files/chapter_12/aciiCodeFile.txt");

        try (PrintWriter writer = new PrintWriter(aciiCodeFile);)
        {
            URL url = new URL("https://theasciicode.com.ar/ascii-codes.txt");
            Scanner readUrl = new Scanner(url.openStream());
            StringBuilder aciiTable = new StringBuilder();

            while (readUrl.hasNext())
            {
                String line = readUrl.nextLine();
                aciiTable.append(line + "\n");
            }
            readUrl.close();

            writer.print(aciiTable.toString());

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}

