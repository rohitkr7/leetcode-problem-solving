class Solution {
    // Time Complexity: O(n), where n is the length of nums (single pass through array).
    // Space Complexity: O(1) auxiliary space, since modifications are performed in-place.
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;        
    }
}