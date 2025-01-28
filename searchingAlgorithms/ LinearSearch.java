import java.util.List;

public class LinearSearch {
    public static int linearSearch(List<Integer> arr, int target) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == target) {
                return i; // Return the index if the element is found
            }
        }
        return -1; // Return -1 if the element is not found
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(10, 23, 45, 70, 11, 15);
        int target = 70;
        int result = linearSearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}

