class TreeNode:
    def __init__(self):
        self.leftPointer = -1
        self.data = ''
        self.rightPointer = -1

rootPointer = -1
freePointer = 0
size = int(input("Enter the size of tree ADT:"))
Tree = [TreeNode() for i in range(size)]

for i in range(len(Tree)-1):
    Tree[i].leftPointer = i+1

def addNode(item):
    global rootPointer, freePointer, Tree
    if freePointer != -1:
        newNode = freePointer
        Tree[newNode].data = item
        freePointer = Tree[freePointer].leftPointer
        Tree[newNode].leftPointer = -1
        Tree[newNode].rightPointer = -1
        
        if rootPointer == -1:
            rootPointer = 0
        else:
            placed = False  
            currPointer = rootPointer
            while not placed:
                if item < Tree[currPointer].data:
                    if Tree[currPointer].leftPointer == -1:
                        Tree[currPointer].leftPointer = newNode
                        placed = True
                    else: 
                        currPointer = Tree[currPointer].leftPointer
                else: 
                    if Tree[currPointer].rightPointer == -1: 
                        Tree[currPointer].rightPointer = newNode
                        placed = True
                    else:
                        currPointer = Tree[currPointer].rightPointer

def inorder(pointer):
    """Left -> Root -> Right"""
    if pointer != -1:
        inorder(Tree[pointer].leftPointer)
        print(Tree[pointer].data, end=' ')
        inorder(Tree[pointer].rightPointer)

def preorder(pointer):
    """Root -> Left -> Right"""
    if pointer != -1:
        print(Tree[pointer].data, end=' ')
        preorder(Tree[pointer].leftPointer)
        preorder(Tree[pointer].rightPointer)

def postorder(pointer):
    """Left -> Right -> Root"""
    if pointer != -1:
        postorder(Tree[pointer].leftPointer)
        postorder(Tree[pointer].rightPointer)
        print(Tree[pointer].data, end=' ')

# Test the tree
addNode("E")
addNode("H")
addNode("C")
addNode("G")
addNode("B")

# Print traversals
print("\nInorder traversal:", end=' ')
inorder(rootPointer)

print("\nPreorder traversal:", end=' ')
preorder(rootPointer)

print("\nPostorder traversal:", end=' ')
postorder(rootPointer)
print()



