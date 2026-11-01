/**
 * LEETCODE POTD: November 1, 2026
 * 453. Minimum Moves to Equal Array Elements (Medium)
 * 
 * MATH SHORTCUT PROOF:
 * Incrementing (n - 1) elements by 1 is mathematically identical to 
 * subtracting 1 from the largest element. Relative to each other, all elements 
 * are simply being driven down to match the absolute minimum value (minVal).
 * 
 * Total Moves = Sum(nums[i] - minVal)
 * Total Moves = TotalSum - (n * minVal)
 * 
 * Complexity:
 * Time Complexity: O(n) - Single pass through the array.
 * Space Complexity: O(1) - Constant space.
 */
class POTD_2026_11_01_LC453 { // Class name matches file name exactly
    public int minMoves(int[] nums) {
        int minVal = nums[0];
        long totalSum = 0; // Protects against integer overflow

        // Single pass execution
        for (int num : nums) {
            if (num < minVal) {
                minVal = num;
            }
            totalSum += num;
        }

        return (int) (totalSum - ((long) minVal * nums.length));
    }
}
