package chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise_31
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File dir = new File("src/Files/chapter_12/Baby_Names");
        String[] files = dir.list();

        if (files.length == 0)
        {
            System.out.print("Current directory is empty.");
            System.exit(0);
        }

        Scanner input = new Scanner(System.in);

        File[] fileList = new File[files.length];
        for (int i = 0; i < fileList.length; i++) {
            fileList[i] = new File("src/Files/chapter_12/Baby_Names/" + files[i]);
        }
        String year = getYear(input);
        char gender = getGender(input);
        String name = getName(input);

        getData(fileList, year, gender, name);

        input.close();
    }

    public static void getData(File[] fileList, String year, char gender, String name) throws FileNotFoundException
    {
        for (int i = 0; i < fileList.length; i++)
        {
            if (fileList[i].toString().equals("src\\Files\\chapter_12\\Baby_Names\\babynamesranking" + year + ".txt"))
                try (Scanner reader = new Scanner(fileList[i]))
                {
                    if (Character.toUpperCase(gender) == 'M')
                    {
                        while (reader.hasNext())
                        {
                            String[] getData = reader.nextLine().split(" ");

                            if (getData[1].equals(name)) {
                                System.out.print(name + " is ranked " + getData[0] + " in " + year + ".");
                                System.exit(1);
                            }
                        }
                    }

                    if (Character.toUpperCase(gender) == 'F')
                    {
                        while (reader.hasNext())
                        {
                            String[] getData = reader.nextLine().split(" ");

                            if (getData[2].equals(name)) {
                                System.out.print(name + " is ranked " + getData[0] + " in " + year + ".");
                                System.exit(1);
                            }
                        }
                    }
                    System.out.print(name + " is not within top 1000 in year " + year + ".");
                }
        }
    }

    public static String getName(Scanner input)
    {
        System.out.print("Enter a name: ");
        String name = input.next();
        boolean correctValue = false;

        while (!correctValue)
        {
            for (int i = 0; i < name.length(); i++)
                if (!Character.isAlphabetic(name.charAt(i)))
                {
                    System.out.print("Enter another name: ");
                    name = input.next();
                }
                else if (name.length() - 1 == i)
                    correctValue = true;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
    }

    public static char getGender(Scanner input)
    {
        char gender = 0;
        boolean correctValue = false;

        while (!correctValue)
        {
            try
            {
                System.out.print("Enter a gender (M | F) > ");
                gender = Character.toUpperCase(input.next().charAt(0));

                while (gender != 'M' && gender != 'F')
                {
                    System.out.print("Enter M or F > ");
                    gender = Character.toUpperCase(input.next().charAt(0));
                }
                correctValue = true;
            }
            catch (Exception ex)
            {
                System.out.println("Incorrect value, try again.");
            }
        }
        return gender;
    }

    public static String getYear(Scanner input)
    {
        String year = null;
        boolean correctValue = false;

        while (!correctValue)
        {
            try
            {
                System.out.print("Enter a year (2001 - 2010) > ");
                year = input.next();

                while (Integer.parseInt(year) < 2001 || Integer.parseInt(year) > 2010)
                {
                    System.out.print("Year must range from 2001 - 2010 > ");
                    year = input.next();
                }
                correctValue = true;
            }
            catch (Exception ex)
            {
                System.out.println("Incorrect value, try again.");
            }
        }
        return year;
    }
}
