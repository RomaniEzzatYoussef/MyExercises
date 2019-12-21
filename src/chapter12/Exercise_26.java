package chapter12;

import java.io.File;
import java.util.Scanner;

public class Exercise_26
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        boolean loop = true;
        while (loop)
        {
            System.out.print("\nEnter 1 Create Dir\n\t  2 Delete Dir\n\t  3 ---  Exit: ");
            int choose = input.nextInt();

            if (choose == 1)
            {
                System.out.print("Enter name of directory: ");
                String dirName = input.next();
                createDir(dirName);


            } else if (choose == 2)
            {
                System.out.print("Enter name of directory to delete: ");
                String dirNameDelete = input.next();
                deleteDir(dirNameDelete);
            } else if (choose == 3)
                loop = false;

        }

        input.close();
    }

    public static void createDir(String dirName)
    {
        if (new File(dirName).mkdir())
            System.out.print("Directory " + dirName + " created.");
        else
            System.out.print("Directory " + dirName + " already exist.");
    }

    public static void deleteDir(String dirName)
    {
        if (new File(dirName).delete())
            System.out.print("Directory " + dirName + " Deleted.");
        else
            System.out.print("Directory " + dirName + " doesn't exist.");
    }
}
