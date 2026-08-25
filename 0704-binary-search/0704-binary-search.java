class Solution {
    // Time: O(log(n)) - Search space is halved each iteration. 
    // With each iteration, the algorithm cuts the search interval in half (n to n/2 to n/4 ... 1).
    // Space: O(1) - Uses constant extra space for pointers.

    public int search(int[] nums, int target) {
        // Define an inclusive search range: [left, right]
        int left = 0;
        int right = nums.length - 1;

        // Condition 'left <= right' ensures single-element intervals [left, left] are checked
        while (left <= right) {
            // Prevent potential integer overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                // Target must be in the left half; discard mid and everything to the right
                right = mid - 1;
            } else {
                // Target must be in the right half; discard mid and everything to the left
                left = mid + 1;
            }
        }

        // Search space exhausted (left > right); target does not exist in array
        return -1;
    }
}