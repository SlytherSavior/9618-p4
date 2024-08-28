#So there are two ways to create a Linked List in python ! We will try the Object Oriented Programming ( OOP ) way here 

# create a class for each item of linked list 

class Node: 
    def __init__(self): 
        self.data = ""
        self.pointer = -1

start_pointer = -1 
free_pointer = 0  

linked_list = [Node() for x in range(int(input("Enter the maximum number of elements in your linked list")))]
        
#now for the operations of linked_list

def add_node(): 
    #a function to add a node 
    print('hello world')