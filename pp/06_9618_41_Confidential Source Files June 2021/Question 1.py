# (a) The following is pseudocode for the record type node.
# TYPE node
# DECLARE data : INTEGER
# DECLARE nextNode : INTEGER
# ENDTYPE
# Write program code to declare the record type node.
class node: 
  def __init__(self,data,nextNode):
    self.data = data
    self.nextNode = nextNode  
# (b) Write program code for the main program.
# Declare a 1D array of type node with the identifier linkedList, and initialise it with the data
# shown in the table on page 2. Declare the pointers.

linkedList = [node(1,1),node(5,4),node(6,7),node(7,-1),node(2,2),node(0,6),node(0,8),node(56,3),node(0,9),node(0,-1)]
startPointer = 0 
emptyList = 5

# (c) The procedure outputNodes() takes the array and startPointer as parameters. The
# procedure outputs the data from the linked list by following the nextNode values.
# (i) Write program code for the procedure outputNodes().

def outputNodes(linkedList, startPointer): 
  while startPointer != -1 : 
    print(str(linkedList[startPointer].data))
    startPointer = linkedList[startPointer].nextNode


# (ii) Edit the main program to call the procedure outputNodes().
# Take a screenshot to show the output of the procedure outputNodes().

outputNodes(linkedList,startPointer)