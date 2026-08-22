class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        // Because the input array is already sorted, the largest squared values must come from either the far left (most negative) or the far right (most positive).
        // Allocate a result array and fill it from right to left (largest to smallest)

        // Time: O(n) and Space: O(n)
        int left = 0, right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }

        return result;
    }
}