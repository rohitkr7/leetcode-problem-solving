class Solution {
    public void moveZeroes_1(int[] nums) {
        // "relative order" does not mean sorting by value—it means preserving the original sequence of appearance from left to right.

        // insertPos tracks the target index for the next non-zero element.
        // Before encountering the first '0', insertPos == i (self-swaps).
        // Once a '0' is found, insertPos pauses, while i continues.
        // This guarantees insertPos always points to a '0' whenever i > insertPos.

        // Time: O(n) and Space: O(1)
        int insertPos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != insertPos) {
                    int temp = nums[insertPos];
                    nums[insertPos] = nums[i];
                    nums[i] = temp;
                }
                insertPos++;
            }
        }
    }

    // Optimanl Low Write
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        
        // Pass 1: Copy all non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos++] = nums[i];
            }
        }
        
        // Pass 2: Fill the rest with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}