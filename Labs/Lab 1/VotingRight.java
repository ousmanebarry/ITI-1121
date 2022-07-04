import java.util.Scanner;

public class VotingRight {
    public static void main(String[] args) {
        System.out.println("How old are you? ");
        Scanner scanAge = new Scanner(System.in);
        int userAge = scanAge.nextInt();
        System.out.println(votingRightTester(userAge));
        scanAge.close();
    }

    public static String votingRightTester(int value) {
        if(value >= 18) {
            return "You have the right to vote!";
        } else if (value == 17) {
            return "You will be allowed to vote in " + (18 - value) + " year.";
        } else {
            return "You will be allowed to vote in " + (18 - value) + " years.";
        }
    }
}
