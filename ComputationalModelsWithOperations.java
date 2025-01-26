import java.util.Scanner;
import java.util.Stack;

public class ComputationalModelsWithOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an operation to perform:");
            System.out.println("1. PDA Machine");
            System.out.println("2. Turing Machine");
            System.out.println("3. DFA");
            System.out.println("4. NFA");
            System.out.println("5. Regular Expression (RE)");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 6) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            System.out.println("\nSelect a specific operation:");
            System.out.println("a. Even length");
            System.out.println("b. Odd length");
            System.out.println("c. Palindrome");
            System.out.println("d. Even number of '1's");
            System.out.println("e. Odd number of '1's");
            System.out.println("f. Even number of '0's");
            System.out.println("g. Odd number of '0's");
            System.out.print("Enter your operation (a-g): ");
            char operation = scanner.next().charAt(0);
            scanner.nextLine();

            System.out.print("Enter the input string: ");
            String input = scanner.nextLine();

            boolean result = false;

            switch (choice) {
                case 1:
                    result = simulatePDA(input, operation);
                    break;
                case 2:
                    result = simulateTuringMachine(input, operation);
                    break;
                case 3:
                    result = simulateDFA(input, operation);
                    break;
                case 4:
                    result = simulateNFA(input, operation);
                    break;
                case 5:
                    result = simulateRegularExpression(input, operation);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    continue;
            }

            if (result) {
                System.out.println("The string '" + input + "' is accepted.");
            } else {
                System.out.println("The string '" + input + "' is rejected.");
            }
        }

        scanner.close();
    }

    private static boolean simulatePDA(String input, char operation) {
        switch (operation) {
            case 'a': // Even length
                return input.length() % 2 == 0;
            case 'b': // Odd length
                return input.length() % 2 != 0;
            case 'c': // Palindrome
                return input.equals(new StringBuilder(input).reverse().toString());
            case 'd': // Even number of '1's
            case 'e': // Odd number of '1's
                return countOccurrences(input, '1') % 2 == (operation == 'd' ? 0 : 1);
            case 'f': // Even number of '0's
            case 'g': // Odd number of '0's
                return countOccurrences(input, '0') % 2 == (operation == 'f' ? 0 : 1);
            default:
                return false;
        }
    }

    // Turing Machine
    private static boolean simulateTuringMachine(String input, char operation) {
        // Use the same logic as PDA for this example
        return simulatePDA(input, operation);
    }

    // DFA
    private static boolean simulateDFA(String input, char operation) {
        switch (operation) {
            case 'a': // Even length
                return input.length() % 2 == 0;
            case 'b': // Odd length
                return input.length() % 2 != 0;
            case 'c': // Palindrome
                return input.equals(new StringBuilder(input).reverse().toString());
            case 'd': // Even number of '1's
            case 'e': // Odd number of '1's
                return countOccurrences(input, '1') % 2 == (operation == 'd' ? 0 : 1);
            case 'f': // Even number of '0's
            case 'g': // Odd number of '0's
                return countOccurrences(input, '0') % 2 == (operation == 'f' ? 0 : 1);
            default:
                return false;
        }
    }

    private static boolean simulateNFA(String input, char operation) {
        return simulatePDA(input, operation);
    }

    // Regular Expression
    private static boolean simulateRegularExpression(String input, char operation) {
        switch (operation) {
            case 'a': // Even length
                return input.matches("(..)*");
            case 'b': // Odd length
                return input.matches(".(..)*");
            case 'c': // Palindrome
                return input.equals(new StringBuilder(input).reverse().toString());
            case 'd': // Even number of '1's
                return input.matches("(.*1.*1)*");
            case 'e': // Odd number of '1's
                return input.matches(".*1(.*1.*1)*");
            case 'f': // Even number of '0's
                return input.matches("(.*0.*0)*");
            case 'g': // Odd number of '0's
                return input.matches(".*0(.*0.*0)*");
            default:
                return false;
        }
    }

    // count occurrences of a character in a string
    private static int countOccurrences(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) count++;
        }
        return count;
    }
}

// In java, I create a machine which accepts user inputs and give outputs