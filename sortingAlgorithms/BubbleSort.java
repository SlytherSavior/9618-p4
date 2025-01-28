import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] dataArr) {
        int topPointer = dataArr.length - 2;
        while (topPointer > 0) {
            for (int i = 0; i <= topPointer; i++) {
                if (dataArr[i + 1] < dataArr[i]) {  // Use [] for indexing
                    // Swap the elements
                    int temp = dataArr[i + 1];
                    dataArr[i + 1] = dataArr[i];
                    dataArr[i] = temp;
                }
            }
            topPointer--;  // Decrease the topPointer after each pass
        }
        return dataArr;
    }

    public static void main(String[] args) {
        int[] dataArr = {0, 23, 432, 43, 54, 123, 6434, 211, 321, 2356, 1, 235};
        int[] sortedArr = bubbleSort(dataArr);
        System.out.println(Arrays.toString(sortedArr));
    }
