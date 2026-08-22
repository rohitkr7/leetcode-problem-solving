class Solution {
    public int missingNumber_1(int[] nums) {

        // Using Mathematical formula to find out the missing number
        // Time: O(n)
        // Space: O(1)
        int n = nums.length;
        int totalSumIncludingMissingNum = n * (n + 1) / 2;
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        return totalSumIncludingMissingNum - sum;
    }

    // If you XOR all indices from 0 to n and XOR all values in nums, every matching number cancels itself out, leaving only the missing number.
    // O(n) time and O(1) space
    public int missingNumber_2(int[] nums) {
        int xor = nums.length; // initialize with n

        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }

        return xor;
    }

    // Cyclic Sort / Index Placement: Place each number x at its corresponding index nums[x]. After sorting in-place, the index that does not match its value is the missing number (O(n) Time, O(1) Space, modifies input).
    public int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;

        // Step 1: Cyclic sort
        while (i < n) {
            int correctIndex = nums[i];

            // Place nums[i] at index nums[i] if it's within bounds [0, n - 1]
            if (correctIndex < n && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // Step 2: Find the missing index
        for (int index = 0; index < n; index++) {
            if (nums[index] != index) {
                return index;
            }
        }

        // If all indices 0 to n-1 match, n is missing
        return n;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
    Other alternative approaches
    HashSet / Boolean Array: Insert all elements into a set or boolean array, then check which number from 0 to n is absent (O(n) Time, O(n) Space).
    
    Sorting & Binary Search: Sort the array and use binary search to find the first index where nums[mid] != mid (O(n log n) Time, O(1) Space).
    */

}