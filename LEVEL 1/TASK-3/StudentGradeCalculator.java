import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of grades
        System.out.print("Enter the number of grades: ");
        int numberOfGrades = scanner.nextInt();

        // Initialize a variable to store the sum of grades
        double sumOfGrades = 0;

        // Loop to input each grade
        for (int i = 1; i <= numberOfGrades; i++) {
            System.out.print("Enter grade " + i + ": ");
            double grade = scanner.nextDouble();
            sumOfGrades += grade; // Add the grade to the sum
        }

        // Calculate the average
        double averageGrade = sumOfGrades / numberOfGrades;

        // Display the average grade
        System.out.println("The average grade is: " + averageGrade);

        // Close the scanner
        scanner.close();
    }
}
