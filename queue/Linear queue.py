#LINEAR QUEUE IMPLEMENTATION IN PYTHON
max_length = 0 
front_pointer = 0 
end_pointer = -1
queue = []


#defining method to create the queue 
def create(): 
    global max_length,front_pointer,end_pointer,queue   
    # Combined the codes, so that we dont need to define another variable
    queue = ['' for x in range(int(input("Enter the maximum size of the queue you want")))] 
    print(f'This is the queue you defined {queue}')

#calling this create method at the beginning 
create()

#defining methods to enqueue and dequeue

def enqueue(): 
    global end_pointer,front_pointer,queue
    if end_pointer != len(queue) - 1 :
        value = input("Enter the value of want to enter \n")
        queue[end_pointer + 1] = value
        end_pointer += 1 
        print(f'added {value} the queue is now {queue} ')
    else: 
        print(" Sorry the queue is already full ( As it is a linear queue so no more added )")

def rearrange(): 
    global queue,front_pointer,end_pointer
    while front_pointer != 0 : 
        for i in range(0,len(queue) - 1):
            queue[i] = queue[i + 1]
        front_pointer -= 1
        end_pointer -= 1
        queue[-1] = ''


def dequeue(): 
    global front_pointer,end_pointer,queue 
    queue[front_pointer] = ''
    front_pointer += 1 
    rearrange()
    print(queue)
  

while True: 
    choice = int(input("Enter the task you want to perform \n 1 for enqueue \n 2 for dequeue \n 3 for leaving / exit \n"))
    if choice == 1 : 
        enqueue()
    elif choice == 2: 
        dequeue()
    elif choice == 3: 
        break
    else: 
        print(f'You chose {choice}, please choose a vali d choice')
    
