class Solution {
    public void moveZeroes(int[] nums) {
        // "relative order" does not mean sorting by value—it means preserving the original sequence of appearance from left to right.

        // Time: O(n) and Space: O(1)
        int insertPos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap non-zero element with the element at insertPos
                int temp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = temp;

                insertPos++;
            }
        }
    }
}