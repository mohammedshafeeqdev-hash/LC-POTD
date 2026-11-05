```java
import java.util.Arrays;

class Solution {

    /*
     * BRUTE FORCE APPROACH
     *
     * Logic:
     * For every element in arr1, check every element in arr2.
     * If any absolute difference is <= d, reject that element.
     * Otherwise, increase the count.
     *
     * Time Complexity: O(n * m)
     * Space Complexity: O(1)
     */
    public int bruteForce(int[] arr1, int[] arr2, int d) {

        int count = 0;

        for (int num1 : arr1) {

            boolean valid = true;

            for (int num2 : arr2) {

                if (Math.abs(num1 - num2) <= d) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }


    /*
     * BETTER APPROACH - SORTING + BINARY SEARCH
     *
     * Logic:
     * Sort arr2.
     * For each element in arr1, find the first element in arr2
     * that is greater than or equal to num1 - d.
     *
     * If that element is <= num1 + d, a nearby element exists.
     * Otherwise, num1 is valid.
     *
     * Time Complexity: O(m log m + n log m)
     * Space Complexity: O(1) auxiliary space (sorting space excluded)
     */
    public int better(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr2);

        int count = 0;

        for (int num : arr1) {

            int left = 0;
            int right = arr2.length - 1;
            int index = arr2.length;

            // Find first element >= num - d
            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (arr2[mid] >= num - d) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Check whether an element exists within [num-d, num+d]
            if (index == arr2.length || arr2[index] > num + d) {
                count++;
            }
        }

        return count;
    }


    /*
     * OPTIMAL APPROACH - SORTING + TWO POINTERS
     *
     * Logic:
     * Sort both arrays.
     * For each element in arr1, move the pointer in arr2
     * until it reaches an element >= num1 - d.
     *
     * If that element is > num1 + d, num1 is valid.
     *
     * Time Complexity: O(n log n + m log m + n + m)
     * Space Complexity: O(1) auxiliary space (sorting space excluded)
     */
    public int optimal(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int count = 0;
        int j = 0;

        for (int num : arr1) {

            while (j < arr2.length && arr2[j] < num - d) {
                j++;
            }

            if (j == arr2.length || arr2[j] > num + d) {
                count++;
            }
        }

        return count;
    }
}
```
