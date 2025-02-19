package ADT.Binary_Tree;

import java.util.Scanner;

class TreeNode {
    int leftPointer;
    String data;
    int rightPointer;

    public TreeNode() {
        this.leftPointer = -1;
        this.data = "";
        this.rightPointer = -1;
    }
}

public class BinaryTree {
    static int rootPointer = -1;
    static int freePointer = 0;
    static int size;
    static TreeNode[] tree;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of tree ADT: ");
        size = scanner.nextInt();
        tree = new TreeNode[size];
        for (int i = 0; i < size; i++) {
            tree[i] = new TreeNode();
            if (i < size - 1) {
                tree[i].leftPointer = i + 1;
            }
        }

        addNode("E");
        addNode("H");
        addNode("C");
        addNode("G");
        addNode("B");

        System.out.print("\nInorder traversal: ");
        inorder(rootPointer);

        System.out.print("\nPreorder traversal: ");
        preorder(rootPointer);

        System.out.print("\nPostorder traversal: ");
        postorder(rootPointer);
        System.out.println();

        scanner.close();
    }

    public static void addNode(String item) {
        if (freePointer != -1) {
            int newNode = freePointer;
            tree[newNode].data = item;
            freePointer = tree[freePointer].leftPointer;
            tree[newNode].leftPointer = -1;
            tree[newNode].rightPointer = -1;

            if (rootPointer == -1) {
                rootPointer = 0;
            } else {
                boolean placed = false;
                int currPointer = rootPointer;
                while (!placed) {
                    if (item.compareTo(tree[currPointer].data) < 0) {
                        if (tree[currPointer].leftPointer == -1) {
                            tree[currPointer].leftPointer = newNode;
                            placed = true;
                        } else {
                            currPointer = tree[currPointer].leftPointer;
                        }
                    } else {
                        if (tree[currPointer].rightPointer == -1) {
                            tree[currPointer].rightPointer = newNode;
                            placed = true;
                        } else {
                            currPointer = tree[currPointer].rightPointer;
                        }
                    }
                }
            }
        }
    }

    public static void inorder(int pointer) {
        if (pointer != -1) {
            inorder(tree[pointer].leftPointer);
            System.out.print(tree[pointer].data + " ");
            inorder(tree[pointer].rightPointer);
        }
    }

    public static void preorder(int pointer) {
        if (pointer != -1) {
            System.out.print(tree[pointer].data + " ");
            preorder(tree[pointer].leftPointer);
            preorder(tree[pointer].rightPointer);
        }
    }

    public static void postorder(int pointer) {
        if (pointer != -1) {
            postorder(tree[pointer].leftPointer);
            postorder(tree[pointer].rightPointer);
            System.out.print(tree[pointer].data + " ");
        }
    }
}
