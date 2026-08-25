class Solution {
    // Time: O(n)
    // Space: O(1)
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            //Note: Select the sorted half first and then decide whether the target element is within that sorted harlf or not according to that change your left and right pointers boundary.
            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left sorted portion
                } else {
                    left = mid + 1; // Target is in the right portion
                }
            }
            // Otherwise, the right half must be sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right sorted portion
                } else {
                    right = mid - 1; // Target is in the left portion
                }
            }
        }

        return -1;
    }
}