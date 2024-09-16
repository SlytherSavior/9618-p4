def insertion_sort(arr):
    # Traverse through the array starting from index 1
    for i in range(1, len(arr)):
        key = arr[i]  # Element to be positioned correctly
        j = i - 1

        # Shift elements greater than 'key' to the right
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        
        # Insert 'key' in its correct position
        arr[j + 1] = key

# Example usage
arr = [12, 11, 13, 5, 6]
insertion_sort(arr)
print(arr)  # Output the sorted array
