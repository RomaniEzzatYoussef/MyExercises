package chapter12;

public class Exercise_28
{
    public static void main(String[] args)
    {
        String numRegex   = ".*[0-9].*";
        String alphaRegex = ".*[A-Z].*";
        String regex =  "\\d+";


        String str = "Exercise0_5.text";

        if (str.matches("Exercise[0-9]_[0-9].text"))
            System.out.println(str);
        else
            System.out.println(str + " doesn't equal Exercise" + regex + "_" + regex +".txt");

    }
}
