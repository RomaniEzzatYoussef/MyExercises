package chapter12;

import java.io.File;

public class Exercise_29
{
    public static void main(String[] args)
    {
        File dir = new File("src/Files/chapter_12/Exercise_29");
        String[] filesName = dir.list();
        if (!dir.exists())
        {
            System.out.print("Directory doesn't exist.");
            System.exit(0);
        }

        for (int i = 0; i < filesName.length; i++)
        {
            if (filesName[i].matches("Exercise[0-9]+_[0-9]+.txt"))
            {
                String s = filesName[i];
                String newName = s.substring(0, s.indexOf('_') + 1) + "0" + s.substring(s.indexOf('_') - 1) ;

                File file = new File("src/Files/chapter_12/Exercise_29/" + filesName[i]);
                file.renameTo(new File("src/Files/chapter_12/Exercise_29/" + newName));
            }
            else
                System.out.println(filesName[i] + " doesn't match");
        }

    }
}
