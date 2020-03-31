import com.sun.xml.internal.bind.api.impl.NameConverter;
import problems.MaxSumSubArray;

import java.util.Scanner;

public class ProblemController {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Greetings!  Which problem would you like to test today?  Or, press Q to quit");
            System.out.println("1 - Max Sum of a Sub-Array");
            String input = scanner.next();
            if(!determineProblem(input)) {
                System.out.println("Program ending.  Good-bye.");
                return;
            }
        }
        
    }

    private static boolean determineProblem(String input) {

        switch (input) {
            case "1" :
                MaxSumSubArray.findMaxSumInteractive();
                break;
            case "Q" :
                return false;
            case "q" :
                return false;
            default:
                System.out.println("Invalid input.  Please try again.");
        }
        return true;
    }
}
