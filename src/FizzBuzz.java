import java.util.Scanner;

public class FizzBuzz {

    // This method Perform FizzBuzz logic
    public static void fizzBuzz(int max) {
        for (int i = 1; i <= max; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum value for FizzBuzz: ");
        int max = scanner.nextInt();

        fizzBuzz(max); // Call FizzBuzz with the user input value
    }
}
