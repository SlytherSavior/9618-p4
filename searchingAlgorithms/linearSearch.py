def linear_search(arr, target):
    """
    Function to perform linear search on a list.

    :param arr: List of elements
    :param target: The element to search for
    :return: Index of the target element if found, otherwise -1
    """
    for i in range(len(arr)):
        if arr[i] == target:
            return i  # Return the index if the element is found
    return -1  # Return -1 if the element is not found


# Example usage:
arr = [10, 23, 45, 70, 11, 15]
target = 70
result = linear_search(arr, target)

if result != -1:
    print(f"Element found at index {result}")
else:
    print("Element not found")
