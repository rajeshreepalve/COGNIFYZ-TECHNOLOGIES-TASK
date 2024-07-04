import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptionDecryption {
    private static final int SHIFT = 3; // Shift value for Caesar cipher

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to choose between encryption and decryption
        System.out.print("Do you want to encrypt or decrypt a file? (e/d): ");
        char choice = scanner.nextLine().charAt(0);

        // Prompt the user to input the file name or path
        System.out.print("Enter the file name or path: ");
        String filePath = scanner.nextLine();

        // Read the contents of the file
        String fileContents = readFile(filePath);

        if (fileContents == null) {
            System.out.println("Error reading the file. Please check the file path and try again.");
            scanner.close();
            return;
        }

        String result;
        if (choice == 'e' || choice == 'E') {
            // Encrypt the file contents
            result = encrypt(fileContents);
            System.out.println("File encrypted successfully.");
        } else if (choice == 'd' || choice == 'D') {
            // Decrypt the file contents
            result = decrypt(fileContents);
            System.out.println("File decrypted successfully.");
        } else {
            System.out.println("Invalid choice. Please enter 'e' for encryption or 'd' for decryption.");
            scanner.close();
            return;
        }

        // Save the result to a new file
        System.out.print("Enter the output file name or path: ");
        String outputFilePath = scanner.nextLine();
        writeFile(outputFilePath, result);

        System.out.println("Result saved to " + outputFilePath);
        scanner.close();
    }

    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            return null;
        }
        return content.toString();
    }

    private static void writeFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error writing to the file.");
        }
    }

    private static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) ((c - base + SHIFT) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    private static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                decrypted.append((char) ((c - base - SHIFT + 26) % 26 + base));
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}
