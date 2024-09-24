dataArr = [0, 23, 432, 43, 54, 123, 6434, 211, 321, 2356, 1, 235]

def BubbleSort(dataArr):
    topPointer = len(dataArr) - 2
    while topPointer > 0:
        for i in range(0, topPointer + 1):
            if dataArr[i + 1] < dataArr[i]:  # Use [] for indexing
                # Swap the elements
                dataArr[i + 1], dataArr[i] = dataArr[i], dataArr[i + 1]
        topPointer -= 1  # Decrease the topPointer after each pass
    return dataArr

# Example usage
sortedArr = BubbleSort(dataArr)
print(sortedArr)
