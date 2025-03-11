import java.util.Scanner;

public class CircularQueue {
    static int maxLenght = 0;
    static int frontPointer = 0;
    static int endPointer = -1;
    static String[] queue;
    static int noOfElements = 0;
    static Scanner scanner = new Scanner(System.in);

    // defining the create method
    public static void create() {
        System.out.println("Enter the maximum size of the queue you want");
        maxLenght = scanner.nextInt();
        queue = new String[maxLenght];
    }

    public static void enQueue() {
        if (noOfElements != maxLenght) {
            System.out.println("Enter the data you want to add in the queue \n");
            int value = 0;
            try {
                value = scanner.nextInt();
                queue[endPointer] = Integer.toString(value);
            } catch (Exception e) {
                System.out.println("An error occured, are you sure you entered an integer? ");
            }
            endPointer = (endPointer + 1) % maxLenght;
            System.out.println("Value " + value + " is added the queue is now: " + java.util.Arrays.toString(queue));

        }
    }

    public static void main(String[] args) {

    }
}
