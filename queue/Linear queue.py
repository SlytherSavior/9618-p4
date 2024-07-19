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
        value = input("Enter the value of want to enter")
        queue[end_pointer + 1] = value
        end_pointer += 1 
        print(f'added {value} the queue is now {queue} ')
    else: 
        print(" Sorry the queue is already full ( As it is a linear queue so no more added )")

def dequeue(): 
    global front_pointer,end_pointer,queue
