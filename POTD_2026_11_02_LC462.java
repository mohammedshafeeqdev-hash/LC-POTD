/**
 * LEETCODE POTD: November 2, 2026
 * 462. Minimum Moves to Equal Array Elements II (Medium)
 * 
 * MATH SHORTCUT PROOF:
 * To minimize the absolute differences, the target value must be the median of the array. 
 * If we sort the array, the element at index n / 2 represents a perfect balancing point. 
 * Any move away from the median would increase the total cost for more elements than it decreases.
 * 
 * Total Moves = Sum(abs(nums[i] - median))
 * Alternate strategy: Sum(nums[right] - nums[left]) using two pointers after sorting.
 * 
 * Complexity:
 * Time Complexity: O(n log n) - Dominated by the array sorting step.
 * Space Complexity: O(1) - Constant space if sorted in place (or O(log n) depending on dual-pivot quicksort stack).
 */
import java.util.Arrays;

class POTD_2026_11_02_LC462 { // Class name matches file name exactly
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int median = nums[nums.length / 2];
        int totalMoves = 0;
        
        // Accumulate absolute differences from the median
        for (int num : nums) {
            totalMoves += Math.abs(num - median);
        }
        
        return totalMoves;
    }
}
