import java.util.Scanner;

public class stackJava {
    // Initialize the maximum length of the stack
    static int maxLength = 0;

    // Initialize the stack and top pointer , static variables cause we need them to be global
    static String[] stack;
    static int topPointer = -1;

    // Function to create a stack with user-defined size
    public static void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack you want: ");
        maxLength = scanner.nextInt();
        stack = new String[maxLength];
        scanner.close();
    }

    // Function to push an element onto the stack
    public static void push() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string value you want to add in your stack:\n");
        String val = scanner.nextLine();
        topPointer++;  // Increment the top pointer
        stack[topPointer] = val; // Add the value to the stack
        System.out.println(java.util.Arrays.toString(stack));  // Print the current state of the stack
        scanner.close();
    }
    
    // Function to pop an element from the stack
    public static void pop() {
        stack[topPointer] = null;  // Remove the last element from the stack
        topPointer--;  // Decrement the top pointer
        System.out.println("You have removed the last element from your stack.");
        System.out.println(java.util.Arrays.toString(stack));  // Print the current state of the stack
    }
    
    public static void main(String[] args) {
        // Call the create function to set the stack size when the program starts
        create();
        
        // Main loop to handle user inputs
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nPress 1 and enter if you want to add in your stack,\n"
            + "Press 2 and enter if you want to remove some element from your stack,\n"
            + "Press 3 and enter if you want to quit: ");
            int userChoice = scanner.nextInt();
            
            if (userChoice == 1) {
                if (topPointer < maxLength - 1) { // Check if the stack is not full
                    push();
                } else {
                    System.out.println("You have already reached max stack length.");
                }
            } else if (userChoice == 2) {
                if (topPointer >= 0) {  // Check if the stack is not empty
                    pop();
                } else {
                    System.out.println("There is no item to remove from the stack.");
                }
            } else if (userChoice == 3) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Please enter either 1, 2, or 3, not any other number.");
            }
        }
        scanner.close();
    }
}

