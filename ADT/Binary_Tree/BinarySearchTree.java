class Node {
    int value;
    Node left, right;

    public Node(int item) {
        value = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.value) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.value) {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }

    public boolean search(int key) {
        return searchRecursive(root, key) != null;
    }

    private Node searchRecursive(Node root, int key) {
        if (root == null || root.value == key) {
            return root;
        }
        if (key < root.value) {
            return searchRecursive(root.left, key);
        } else {
            return searchRecursive(root.right, key);
        }
    }

    public void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.value + " ");
            inorderRecursive(root.right);
        }
    }

    public void preorder() {
        preorderRecursive(root);
    }

    private void preorderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    public void postorder() {
        postorderRecursive(root);
    }

    private void postorderRecursive(Node root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.value + " ");
        }
    }

    public int findMin() {
        return findMinRecursive(root);
    }

    private int findMinRecursive(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.value;
    }

    public int findMax() {
        return findMaxRecursive(root);
    }

    private int findMaxRecursive(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.value;
    }

    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.value) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.value) {
            root.right = deleteRecursive(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.value = findMinRecursive(root.right);
            root.right = deleteRecursive(root.right, root.value);
        }
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        System.out.print("In-order Traversal: ");
        bst.inorder();
        System.out.println();
        System.out.print("Pre-order Traversal: ");
        bst.preorder();
        System.out.println();
        System.out.print("Post-order Traversal: ");
        bst.postorder();
        System.out.println();
        System.out.println("Search for 40: " + (bst.search(40) ? "Found" : "Not Found"));
        System.out.println("Search for 25: " + (bst.search(25) ? "Found" : "Not Found"));
        System.out.println("Minimum value: " + bst.findMin());
        System.out.println("Maximum value: " + bst.findMax());
        bst.delete(20);
        System.out.print("In-order Traversal after deleting 20: ");
        bst.inorder();
        System.out.println();
        bst.delete(30);
        System.out.print("In-order Traversal after deleting 30: ");
        bst.inorder();
        System.out.println();
        bst.delete(50);
        System.out.print("In-order Traversal after deleting 50: ");
        bst.inorder();
        System.out.println();
    }
}
