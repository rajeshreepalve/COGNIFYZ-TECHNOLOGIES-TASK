import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a password
        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();

        // Analyze the password strength
        String strength = checkPasswordStrength(password);

        // Display the feedback
        System.out.println("Password strength: " + strength);

        // Close the scanner
        scanner.close();
    }

    public static String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        // Check each character in the password
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUppercase = true;
            if (Character.isLowerCase(ch)) hasLowercase = true;
            if (Character.isDigit(ch)) hasNumber = true;
            if (specialChars.indexOf(ch) >= 0) hasSpecialChar = true;
        }

        // Determine password strength
        if (length >= 8 && hasUppercase && hasLowercase && hasNumber && hasSpecialChar) {
            return "Very Strong";
        } else if (length >= 8 && ((hasUppercase && hasLowercase) || (hasLowercase && hasNumber) || (hasLowercase && hasSpecialChar))) {
            return "Strong";
        } else if (length >= 6) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }
}
