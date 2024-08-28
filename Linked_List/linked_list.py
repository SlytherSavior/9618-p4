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
        if free_pointer < (len(linked_list) -1):
            free_pointer += 1
        else: 
            free_pointer = -1 
    else:
        print("The linkedList is already full")
    
   

def printNodes():
    print('hello world')



