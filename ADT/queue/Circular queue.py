# Circular queue implementation in python
# A circular queue is a fixed-size queue that wraps around when it reaches the end

# Global variables to maintain queue state
max_length = 0  # Maximum size of the queue
front_pointer = 0  # Points to the front element of the queue
end_pointer = -1  # Points to the last element of the queue
noOfElements = 0  # Tracks current number of elements in the queue
queue = []  # The actual queue array

def create():
    # """Initialize the circular queue with user-specified size"""
    global max_length, front_pointer, end_pointer, queue
    max_length = int(input("Enter the maximum size of the queue you want"))
    # Initialize empty queue with placeholder values
    queue = ['' for x in range(max_length)]
    # print(f'This is the queue you defined {queue}')

def enqueue():
    # """Add an element to the rear of the circular queue"""
    global end_pointer, front_pointer, queue, noOfElements, max_length
    if noOfElements != max_length:  # Check if queue is not full
        value = input("Enter the value of want to enter \n")
        # Calculate next position and add element
        queue[end_pointer + 1] = value
        # Update end_pointer using modulo to wrap around if necessary
        end_pointer = (end_pointer + 1) % max_length
        print(f'added {value} the queue is now {queue} ')
        noOfElements = noOfElements + 1
    else:
        print("Sorry the queue is already full")

def dequeue():
    # """Remove and return the front element from the circular queue"""
    global front_pointer, end_pointer, queue, noOfElements, max_length
    if noOfElements != 0:  # Check if queue is not empty
        # Get front element and clear its position
        value = queue[front_pointer]
        queue[front_pointer] = ''
        # Update front_pointer using modulo to wrap around if necessary
        front_pointer = (front_pointer + 1) % max_length
        noOfElements -= 1
        print(f'removed {value} the queue is now {queue}')
    else:
        print("The queue is empty")

def main():
    # """Test the circular queue implementation"""
    create()    
    enqueue()
    dequeue()

if __name__ == "__main__":
    main()
