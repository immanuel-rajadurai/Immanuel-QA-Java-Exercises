public class UniqueSum {

    //  Calculate the sum of unique values
    public static int uniqueSum(int a, int b, int c) {
        int sum = 0;

        // Check if a is unique
        if (a != b && a != c) {
            sum += a;
        }

        // Check if b is unique
        if (b != a && b != c) {
            sum += b;
        }

        // Check if c is unique
        if (c != a && c != b) {
            sum += c;
        }

        return sum;
    }

    // Main method to test the program
    public static void main(String[] args) {
        // Test cases
        System.out.println("Input (1, 2, 3) -> " + uniqueSum(1, 2, 3)); // Output: 6
        System.out.println("Input (3, 3, 3) -> " + uniqueSum(3, 3, 3)); // Output: 0
        System.out.println("Input (1, 1, 2) -> " + uniqueSum(1, 1, 2)); // Output: 2
    }
}