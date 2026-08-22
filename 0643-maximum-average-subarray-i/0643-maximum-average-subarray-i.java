class Solution {
    public double findMaxAverage(int[] nums, int k) {

        // Time: O(n) and Space: O(1)
        int maxSum = 0;

        int i = 0;
        int j = 0;
        int currentSum = 0;
        // Sum of the first window
        while (j < k) {
            currentSum += nums[j];
            j++;
        }

        maxSum = currentSum;

        // Slide the window across the array
        while (j < nums.length) {
            currentSum +=  nums[j++] - nums[i++]; // j++ and i++ are post-increments
            maxSum = Math.max(maxSum, currentSum);
        }

        return (double) maxSum / k;
    }
}