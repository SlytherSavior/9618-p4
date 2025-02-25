import java.util.Scanner;

class Node {
    String data;
    int pointer;

    public Node() {
        this.data = "";
        this.pointer = -1;
    }
}

public class LinkedList {
    static int startPointer = -1;
    static int freePointer = 0;
    static Node[] linkedList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the linkedlist you want: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (size <= 0) {
            System.out.println("Size must be positive");
            scanner.close();
            return;
        }

        linkedList = new Node[size];
        for (int i = 0; i < size; i++) {
            linkedList[i] = new Node();
        }
        initialize();

        while (true) {
            System.out.println("\nLinked List Operations:");
            System.out.println("1. Add element");
            System.out.println("2. Remove element");
            System.out.println("3. Print list");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    String element = scanner.nextLine();
                    addNode(element);
                    break;
                case 2:
                    System.out.print("Enter element to remove: ");
                    element = scanner.nextLine();
                    removeNode(element);
                    break;
                case 3:
                    printNodes();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void initialize() {
        for (int i = 0; i < linkedList.length - 1; i++) {
            linkedList[i].pointer = i + 1;
        }
        linkedList[linkedList.length - 1].pointer = -1;
    }

    static void addNode(String element) {
        if (element == null || element.trim().isEmpty()) {
            System.out.println("Cannot add null or empty element");
            return;
        }

        if (freePointer != -1) {
            int newNodePlace = freePointer;  // Store the position before updating freePointer
            linkedList[freePointer].data = element;
            freePointer = linkedList[freePointer].pointer;

            if (startPointer == -1) {
                // First element being added
                startPointer = newNodePlace;
                linkedList[newNodePlace].pointer = -1;
            } else {
                // Find correct position to insert based on element value
                int current = startPointer;
                int previous = -1;
                
                while (current != -1 && linkedList[current].data.compareTo(element) < 0) {
                    previous = current;
                    current = linkedList[current].pointer;
                }
                
                if (previous == -1) {
                    // Insert at start
                    linkedList[newNodePlace].pointer = startPointer;
                    startPointer = newNodePlace;
                } else {
                    // Insert between previous and current
                    linkedList[newNodePlace].pointer = linkedList[previous].pointer;
                    linkedList[previous].pointer = newNodePlace;
                }
            }
            System.out.println("Added element: " + element);
            printNodes();
        } else {
            System.out.println("The linkedList is already full");
        }
    }

    static void removeNode(String element) {
        if (startPointer == -1) {
            System.out.println("List is empty, cannot remove element");
            return;
        }
        
        int current = startPointer;
        int previous = -1;
        
        // Find node to remove
        while (current != -1 && !linkedList[current].data.equals(element)) {
            previous = current;
            current = linkedList[current].pointer;
        }
        
        if (current == -1) {
            System.out.println("Element " + element + " not found in list");
            return;
        }
        
        // Remove node
        if (previous == -1) {
            // Removing first element
            startPointer = linkedList[current].pointer;
        } else {
            // Remove from middle/end
            linkedList[previous].pointer = linkedList[current].pointer;
        }
        
        // Add removed node to free list
        linkedList[current].data = "";
        linkedList[current].pointer = freePointer;
        freePointer = current;
        
        System.out.println("Removed element " + element + " from list");
        printNodes();
    }

    static void printNodes() {
        if (startPointer == -1) {
            System.out.println("List is empty");
            return;
        }
        
        System.out.println("\nCurrent list contents:");
        int current = startPointer;
        while (current != -1) {
            System.out.print("Node " + current + ": " + linkedList[current].data + " -> ");
            current = linkedList[current].pointer;
        }
        System.out.println("END");
        System.out.println("Start pointer: " + startPointer);
        System.out.println("Free pointer: " + freePointer);
    }

    // Add these helpful utility methods
    static boolean isEmpty() {
        return startPointer == -1;
    }

    static boolean isFull() {
        return freePointer == -1;
    }

    static int size() {
        int count = 0;
        int current = startPointer;
        while (current != -1) {
            count++;
            current = linkedList[current].pointer;
        }
        return count;
    }
}