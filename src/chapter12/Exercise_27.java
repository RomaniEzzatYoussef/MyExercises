package chapter12;

import java.io.File;

public class Exercise_27
{
    public static void main(String[] args)
    {
        File dir = new File("src/Files/chapter_12/Exercise_27");

        String[] filesName = dir.list();
        if (!dir.exists())
        {
            System.out.print("Directory doesn't exist.");
            System.exit(0);
        }

        for (String str : filesName)
        {
            if (str.matches("Exercise[0-9]+_[0-9]+.text"))
            {
                StringBuilder strBld = new StringBuilder(str);
                strBld.insert(str.indexOf('_') - 1, '0');
                strBld.insert(11, '0');

                new File("src/Files/chapter_12/Exercise_27/" + str).renameTo(
                        new File("src/Files/chapter_12/Exercise_27/" + strBld.toString()));
                System.out.println(str + " renamed to " + strBld.toString());
            }
            else
                System.out.println(str + " doesn't match.");


        }


        String regex =  "\\d+";

        // positive test cases, should all be "true"
        System.out.println("1".matches(regex));
        System.out.println("12345".matches(regex));
        System.out.println("123456789".matches(regex));

        // negative test cases, should all be "false"
        System.out.println("".matches(regex));
        System.out.println("foo".matches(regex));
        System.out.println("aa123bb".matches(regex));
    }
}