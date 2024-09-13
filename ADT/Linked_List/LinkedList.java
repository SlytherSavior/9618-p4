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
        linkedList = new Node[size];
        for (int i = 0; i < size; i++) {
            linkedList[i] = new Node();
        }
        initialize();
        scanner.close();
    }

    static void initialize() {
        for (int i = 0; i < linkedList.length - 1; i++) {
            linkedList[i].pointer = i + 1;
        }
        linkedList[linkedList.length - 1].pointer = -1;
    }

    static void addNode(String element) {
        if (freePointer != -1) {
            linkedList[freePointer].data = element;
            int newNodePlace = freePointer;
            freePointer = linkedList[freePointer].pointer;

            // Now we need to place new node in the correct place 
        } else {
            System.out.println("The linkedList is already full");
        }
    }

    static void printNodes() {
        System.out.println("hello world");
    }
}