class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.value = key

class BinarySearchTree:
    def __init__(self):
        self.root = None

    def insert(self, key):
        if self.root is None:
            self.root = Node(key)
        else:
            self._insert_recursive(self.root, key)

    def _insert_recursive(self, node, key):
        if key < node.value:
            if node.left is None:
                node.left = Node(key)
            else:
                self._insert_recursive(node.left, key)
        elif key > node.value:
            if node.right is None:
                node.right = Node(key)
            else:
                self._insert_recursive(node.right, key)

    def search(self, key):
        return self._search_recursive(self.root, key)

    def _search_recursive(self, node, key):
        if node is None or node.value == key:
            return node
        if key < node.value:
            return self._search_recursive(node.left, key)
        else:
            return self._search_recursive(node.right, key)

    def inorder(self):
        result = []
        self._inorder_recursive(self.root, result)
        return result

    def _inorder_recursive(self, node, result):
        if node:
            self._inorder_recursive(node.left, result)
            result.append(node.value)
            self._inorder_recursive(node.right, result)

    def preorder(self):
        result = []
        self._preorder_recursive(self.root, result)
        return result

    def _preorder_recursive(self, node, result):
        if node:
            result.append(node.value)
            self._preorder_recursive(node.left, result)
            self._preorder_recursive(node.right, result)

    def postorder(self):
        result = []
        self._postorder_recursive(self.root, result)
        return result

    def _postorder_recursive(self, node, result):
        if node:
            self._postorder_recursive(node.left, result)
            self._postorder_recursive(node.right, result)
            result.append(node.value)

    def find_min(self):
        if self.root is None:
            return None
        current = self.root
        while current.left:
            current = current.left
        return current.value

    def find_max(self):
        if self.root is None:
            return None
        current = self.root
        while current.right:
            current = current.right
        return current.value

    def delete(self, key):
        self.root = self._delete_recursive(self.root, key)

    def _delete_recursive(self, node, key):
        if node is None:
            return node
        if key < node.value:
            node.left = self._delete_recursive(node.left, key)
        elif key > node.value:
            node.right = self._delete_recursive(node.right, key)
        else:
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left
            node.value = self._min_value_node(node.right).value
            node.right = self._delete_recursive(node.right, node.value)
        return node

    def _min_value_node(self, node):
        current = node
        while current.left:
            current = current.left
        return current


if __name__ == "__main__":
    bst = BinarySearchTree()
    bst.insert(50)
    bst.insert(30)
    bst.insert(20)
    bst.insert(40)
    bst.insert(70)
    bst.insert(60)
    bst.insert(80)
    print("In-order Traversal:", bst.inorder())
    print("Pre-order Traversal:", bst.preorder())
    print("Post-order Traversal:", bst.postorder())
    print("Search for 40:", bst.search(40) is not None)
    print("Search for 25:", bst.search(25) is not None)
    print("Minimum value:", bst.find_min())
    print("Maximum value:", bst.find_max())
    bst.delete(20)
    print("In-order Traversal after deleting 20:", bst.inorder())
    bst.delete(30)
    print("In-order Traversal after deleting 30:", bst.inorder())
    bst.delete(50)
    print("In-order Traversal after deleting 50:", bst.inorder())
