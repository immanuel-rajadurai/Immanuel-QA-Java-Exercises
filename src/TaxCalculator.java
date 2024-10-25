public class TaxCalculator {

    // Method to calculate tax rate based on salary
    public static double calculateTaxRate(double salary) {
        if (salary >= 0 && salary <= 14999) {
            return 0.0;
        } else if (salary >= 15000 && salary <= 19999) {
            return 0.10;
        } else if (salary >= 20000 && salary <= 29999) {
            return 0.15;
        } else if (salary >= 30000 && salary <= 44999) {
            return 0.20;
        } else if (salary >= 45000) {
            return 0.25;
        } else {
            return -1; //This is an error value for an invalid entry
        }
    }

    // Main method to test the program
    public static void main(String[] args) {
        double salary = 35000; // Example salary
        double taxRate = calculateTaxRate(salary);

        if (taxRate != -1) {
            double taxAmount = salary * taxRate;
            System.out.println("Salary: $" + salary);
            System.out.println("Tax Rate: " + (taxRate * 100) + "%");
            System.out.println("Tax Amount: $" + taxAmount);
        } else {
            System.out.println("Invalid salary amount.");
        }
    }
}
