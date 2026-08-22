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


    // Same solution using a for loop
    public double findMaxAverage_1(int[] nums, int k) {
        int currentSum = 0;
        
        // Sum of first window
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        int maxSum = currentSum;
        
        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return (double) maxSum / k;
    }
}