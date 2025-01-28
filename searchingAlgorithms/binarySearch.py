def binary_search(arr, target):
    """
    Function to perform binary search on a sorted list.

    :param arr: Sorted list of elements
    :param target: The element to search for
    :return: Index of the target element if found, otherwise -1
    """
    low = 0
    high = len(arr) - 1

    while low <= high:
        mid = (low + high) // 2

        # Check if target is present at mid
        if arr[mid] == target:
            return mid
        # If target is greater, ignore the left half
        elif arr[mid] < target:
            low = mid + 1
        # If target is smaller, ignore the right half
        else:
            high = mid - 1

    return -1  # Return -1 if the element is not found


# Example usage:
arr = [10, 15, 23, 45, 70, 99]  # Sorted array
target = 45
result = binary_search(arr, target)

if result != -1:
    print(f"Element found at index {result}")
else:
    print("Element not found")
