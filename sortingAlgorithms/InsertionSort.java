import java.util.Arrays;

public class InsertionSort {
  // Function to perform insertion sort
  public static void insertionSort(int[] arr) {
      // Loop through the array starting from the second element
      for (int i = 1; i < arr.length; i++) {
          int key = arr[i];  // Element to be compared
          int j = i - 1;

          // Move elements greater than 'key' one position ahead
          while (j >= 0 && arr[j] > key) {
              arr[j + 1] = arr[j];
              j = j - 1;
          }
          // Place 'key' in its correct position
          arr[j + 1] = key;
      }
  }

  public static void main(String[] args) {
      int[] arr = {12, 11, 13, 5, 6};
      insertionSort(arr);

      // Output sorted array
      System.out.println(Arrays.toString(arr));
  }
}
