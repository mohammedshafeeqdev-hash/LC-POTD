/**
 * LEETCODE POTD: November 3, 2026
 * 3736. Minimum Moves to Equal Array Elements III (Easy)
 * 
 * MATH SHORTCUT PROOF:
 * Unlike the median-based approach for absolute differences (where increments/decrements are allowed), 
 * here we can ONLY increase elements (nums[i] by 1). 
 * To minimize the total operations, we must bring all elements up to the maximum element in the array. 
 * Targeting any value higher than the maximum would strictly add unnecessary moves for all elements.
 * 
 * Total Moves = Sum(maxVal - nums[i])
 * Alternate formula: (maxVal * n) - Sum(nums[i])
 * 
 * Complexity:
 * Time Complexity: O(n) - Single pass to find the maximum, single pass to calculate the moves.
 * Space Complexity: O(1) - Auxiliary space is constant.
 */
class POTD_2026_11_03_LC3736 { // Class name matches file name exactly
    public int minMoves(int[] nums) {
        int maxVal = nums[0];
        
        // Find the maximum element in the array
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        
        int totalMoves = 0;
        // Accumulate differences from the maximum value
        for (int num : nums) {
            totalMoves += (maxVal - num);
        }
        
        return totalMoves;
    }
}
