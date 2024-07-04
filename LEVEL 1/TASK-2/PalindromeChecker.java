import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a word or phrase
        System.out.println("Enter a word or phrase:");
        String input = scanner.nextLine();

        // Check if the input is a palindrome and print the result
        System.out.println("Is the input a palindrome? " + isPalindrome(input));

        // Close the scanner
        scanner.close();
    }

    public static boolean isPalindrome(String str) {
        // Remove all non-letter and non-digit characters, convert to lowercase
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize pointers
        int left = 0;
        int right = cleanedStr.length() - 1;

        // Compare characters from both ends moving towards the center
        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false; // Characters don't match, not a palindrome
            }
            left++;
            right--;
        }

        return true; // All characters matched, it's a palindrome
    }
}
