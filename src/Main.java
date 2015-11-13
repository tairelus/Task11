package bjs.task11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
BJS, Task11
Program takes expression like 2+3+5, 2*6, and calculate them 
*/
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter expression:");
        String expression = in.nextLine();

        Pattern pattern = Pattern.compile("[\\+\\-\\*/]");
        Matcher matcher = pattern.matcher(expression);

        //Operation symbols found, we have an expression
        if (matcher.find()) {
            String operation = matcher.group();

            //Extract operands
            pattern = Pattern.compile("\\d+\\.?\\d*");
            matcher = pattern.matcher(expression);

            double result = 0;
            if (matcher.find())
                result = Double.parseDouble(matcher.group());
            else
                System.out.println("Operands not found");

            switch (operation) {
                case "+":
                    while (matcher.find())
                        result += Double.parseDouble(matcher.group());
                    break;
                case "-":
                    while (matcher.find())
                        result -= Double.parseDouble(matcher.group());
                    break;
                case "*":
                    while (matcher.find())
                        result *= Double.parseDouble(matcher.group());
                    break;
                case "/":
                    while (matcher.find())
                        result /= Double.parseDouble(matcher.group());
                    break;
                default:
                    result = 0;
                    System.out.println("Unknown operation found");
                    break;
            }

            System.out.println("Expression result: " + result);
        }
        else
            System.out.println("String is not expression with +-*/");
    }
}
