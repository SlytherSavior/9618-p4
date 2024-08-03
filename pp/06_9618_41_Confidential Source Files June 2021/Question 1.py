# 1 (a) The following is pseudocode for the record type node.
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

linkedList = [node(1,1),node(5,4),node(6,7),node(7,-1),node(2,2),
              node(0,6),node(0,8),node(56,3),node(0,9),node(0,-1)]
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


# (d) The function, addNode(), takes the linked list and pointers as parameters, then takes as
# input the data to be added to the end of the linkedList.
# The function adds the node in the next available space, updates the pointers and returns
# True. If there are no empty nodes, it returns False.
# (i) Write program code for the function addNode().

def addNode(linkedList,startPointer,emptyList): 
  tempNode = linkedList[emptyList]
  newNode = node(int(input("enter the data")), -1)
  if emptyList > 9 or emptyList < 0 : 
    return False
  else : 
    linkedList[emptyList] = newNode
    #finding the last element in the linked list 
    previousPointer = 0 
    while(startPointer != -1):
      previousPointer = startPointer
      startPointer = linkedList[startPointer].nextNode 
    linkedList[previousPointer].nextNode = emptyList
    emptyList = tempNode.nextNode # ms prob here ? 
    return True




# (ii) Edit the main program to:
# • call addNode()
# • output an appropriate message depending on the result returned from addNode()
# • call outputNodes() twice; once before calling addNode() and once after calling
# addNode().

def main():
  outputNodes(linkedList,startPointer)
  if addNode(linkedList,startPointer,emptyList) :
    print('node added')
  else:
    print('node full')
  outputNodes(linkedList,startPointer)

# (iii) Test your program by inputting the data value 5 and take a screenshot to show the
main()


# output.


