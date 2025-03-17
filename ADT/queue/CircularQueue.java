import java.util.Arrays;
import java.util.Scanner;

public class CircularQueue {
    static int maxLength = 0;
    static int frontPointer = 0;
    static int endPointer = -1;
    static String[] queue;
    static int noOfElements = 0;
    static Scanner scanner = new Scanner(System.in);

    // defining the create method
    public static void create() {
        System.out.println("Enter the maximum size of the queue you want");
        maxLength = scanner.nextInt();
        queue = new String[maxLength];
    }

    public static void enQueue() {
        if (noOfElements != maxLength) {
            System.out.println("Enter the data you want to add in the queue \n");
            int value = 0;
            try {
                value = scanner.nextInt();
                queue[endPointer + 1] = Integer.toString(value);
                noOfElements += 1;
            } catch (Exception e) {
                System.out.println("An error occured, are you sure you entered an integer? ");
            }
            endPointer = (endPointer + 1) % maxLength;
            System.out.println("Value " + value + " is added the queue is now: " + Arrays.toString(queue));

        } else {
            System.out.println(" The  queue is now full you cannot add any more values");
        }
    }

    public static void deQueue() {
        if (noOfElements != 0) {
            String value = queue[frontPointer];
            queue[frontPointer] = " ";

            frontPointer = ((frontPointer + 1) % maxLength);
            noOfElements -= 1;
            System.out.println("Removed " + value + " the queue is now " + Arrays.toString(queue));
        } else {
            System.out.println(" The queue is empty , what are you even trying to remove lol");
        }
    }

    public static void main(String[] args) {
        create();
        enQueue();
        deQueue();

    }
}
