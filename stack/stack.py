# Initialize the maximum length of the stack
max_length = 0 

# Function to create a stack with user-defined size
def create():
    global max_length
    max_length  = int(input("Enter the size of the stack you want: "))

# Initialize the stack and top pointer
stack = []
toppointer = 0

# Call the create function to set the stack size when the program starts
create()

# Function to push an element onto the stack
def push():
    global toppointer, stack
    val = input("Enter the string value you want to add in your stack:\n")
    stack.append(val)  # Add the value to the stack
    print(stack)  # Print the current state of the stack
    toppointer += 1  # Increment the top pointer

# Function to pop an element from the stack
def pop():
    global toppointer, stack
    stack.pop()  # Remove the last element from the stack
    toppointer -= 1  # Decrement the top pointer
    print("You have removed the last element from your stack.")
    print(stack)  # Print the current state of the stack

# Main loop to handle user inputs
while True:
    user_choice = int(input("\nPress 1 and enter if you want to add in your stack,\n"
                            "Press 2 and enter if you want to remove some element from your stack,\n"
                            "Press 3 and enter if you want to quit: "))
    
    if user_choice == 1:
        if toppointer < max_length:  # Check if the stack is not full
            push()
        else:
            print("You have already reached max stack length.")
    
    elif user_choice == 2:
        if toppointer > 0:  # Check if the stack is not empty
            pop()
        else:
            print("There is no item to remove from the stack.")
    
    elif user_choice == 3:
        print("Exiting the program.")
        break
    
    else:
        print("Please enter either 1, 2, or 3, not any other number.")
