import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RecursiveSearch {

    public static int BinarySearch(int[] inputArray, int dataToFind, int left, int right) {

        if (left >= right) {
            return -1;
        } else {
            int mid = (int) ((left + right) / 2); // this converts a floating point value to integer value in java
            if (inputArray[mid] == dataToFind) {
                return mid;
            } else if (inputArray[mid] < dataToFind) {
                return BinarySearch(inputArray, dataToFind, mid + 1, right);
            } else {
                return BinarySearch(inputArray, dataToFind, left, mid - 1);
            }

        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the length of the array you want \n [only integer values]");
        int length = scanner.nextInt();
        int arr[] = new int[length];
        int value = 0;
        for (int i = 0; i < length; i++) {
            value = rand.nextInt(100);
            arr[i] = value;
        }
        System.out.println("The array you have generated is " + Arrays.toString(arr));

        System.out.println("Enter the value you want to search");

        int searchVal = scanner.nextInt();

        int index = BinarySearch(arr, searchVal, 0, length - 1);
        if (index == -1) {
            System.out.println("Sorry the value does not exist in the array");
        } else {
            System.out.println("The value is in the position " + index);
        }

        scanner.close();

    }
}