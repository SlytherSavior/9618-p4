#node of a linked list
class Node:
    def __init__(self):
        self.data = ''
        self.pointer = -1

start_pointer =-1
free_pointer = 0

linked_list = [Node() for i in range(int(input("Enter the size of the linkedlist you want")))]

def initialize():
    global linked_list
    for i in range(len(linked_list)-1):
        linked_list[i].pointer = i+1
    linked_list[len(linked_list)-1].pointer =-1

initialize()

#method to add element in linked list
def addNode(element):
    global linked_list,start_pointer,free_pointer 
    if free_pointer != -1 :
        linked_list[free_pointer].data = element
        newNodePlace = free_pointer
        free_pointer = linked_list[free_pointer].pointer

        #now wee need to place new node in the correct place 
        if start_pointer == -1:
            # First element being added
            start_pointer = newNodePlace
            linked_list[newNodePlace].pointer = -1
        else:
            # Find correct position to insert based on element value
            current = start_pointer
            previous = -1
            
            # Traverse until we find position where current element is greater
            while current != -1 and linked_list[current].data < element:
                previous = current
                current = linked_list[current].pointer
                
            if previous == -1:
                # Insert at start
                linked_list[newNodePlace].pointer = start_pointer
                start_pointer = newNodePlace
            else:
                # Insert between previous and current
                linked_list[newNodePlace].pointer = linked_list[previous].pointer
                linked_list[previous].pointer = newNodePlace
    else:
        print("The linkedList is already full")

def removeNode(element):
    global linked_list, start_pointer, free_pointer
    
    if start_pointer == -1:
        print("List is empty, cannot remove element")
        return
        
    current = start_pointer
    previous = -1
    
    # Find node to remove
    while current != -1 and linked_list[current].data != element:
        previous = current
        current = linked_list[current].pointer
        
    if current == -1:
        print(f"Element {element} not found in list")
        return
        
    # Remove node
    if previous == -1:
        # Removing first element
        start_pointer = linked_list[current].pointer
    else:
        # Remove from middle/end
        linked_list[previous].pointer = linked_list[current].pointer
        
    # Add removed node to free list
    linked_list[current].data = ''
    linked_list[current].pointer = free_pointer
    free_pointer = current
    
    print(f"Removed element {element} from list")

def printList():
    global linked_list, start_pointer
    if start_pointer == -1:
        print("List is empty")
        return
        
    print("\nCurrent list contents:")
    current = start_pointer
    while current != -1:
        print(f"Node {current}: {linked_list[current].data}", end=" -> ")
        current = linked_list[current].pointer
    print("END")
    print(f"Start pointer: {start_pointer}")
    print(f"Free pointer: {free_pointer}\n")

# Test the linked list
while True:
    print("\nLinked List Operations:")
    print("1. Add element")
    print("2. Remove element") 
    print("3. Print list")
    print("4. Exit")
    
    choice = input("\nEnter your choice (1-4): ")
    
    if choice == '1':
        element = input("Enter element to add: ")
        addNode(element)
        printList()
    elif choice == '2':
        element = input("Enter element to remove: ")
        removeNode(element)
        printList()
    elif choice == '3':
        printList()
    elif choice == '4':
        break
    else:
        print("Invalid choice! Please try again.")
   

def printNodes():
    print('hello world')



