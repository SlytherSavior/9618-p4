import random
"""
Function to perform binary search on a sorted list ,
but the function must be a recursive funciton !
suppose we have a sorted array in ascending order
 with known number of elements.

"""

# Generate a sorted array of 25 random elements
arr = sorted([random.randint(1, 100) for _ in range(25)])
print(f'The array is {arr}')
numberOfItems = 25

def binarySearch(dataToFind, left, right):
    global arr # not necessary as all arrays declared outside functions in python are global
    if left > right :
        return -1
    else:
        mid = int((left + right) / 2)
        if arr[mid] == dataToFind:
            return mid
        elif arr[mid] < dataToFind:
            return binarySearch(dataToFind, mid+1, right)
        else:
            return binarySearch(dataToFind,left,mid-1)

searchVal = int(input("Enter the value you want to search"))
result = binarySearch(searchVal,0,numberOfItems -1 )
print(f'It {'does not exist' if result == -1 else f'is at index {result}'}')



