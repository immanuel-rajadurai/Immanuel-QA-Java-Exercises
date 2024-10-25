import java.time.LocalDate;
import java.time.Period;

public class Person {
    // Instance variables
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    // Class variable to keep track of how many People have been created
    private static int personCount = 0;

    // Constructor to initialize a new Person object
    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        personCount++; // Increment the count whenever a new Person is created
    }

    // Getter and Setter for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter for dateOfBirth
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Getter to calculate and return the person's age as an integer
    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    // Getter to return the total number of Person objects created
    public static int getPersonCount() {
        return personCount;
    }

    // Method to output all the instance variables as a formatted string
    public String getPersonInfo() {
        return "Name: " + firstName + " " + lastName +
                "\nDate of Birth: " + dateOfBirth +
                "\nAge: " + getAge();
    }

    public static void main(String[] args) {
        // Creating instances of the Person class
        Person person1 = new Person("Immanuel", "Rajadurai", LocalDate.of(1990, 5, 15));
        Person person2 = new Person("Jahun", "Koshy", LocalDate.of(1985, 7, 22));

        // Output their information
        System.out.println(person1.getPersonInfo());
        System.out.println("---------------------");
        System.out.println(person2.getPersonInfo());

        // Output the total number of people created
        System.out.println("---------------------");
        System.out.println("Total number of people: " + Person.getPersonCount());
    }
}