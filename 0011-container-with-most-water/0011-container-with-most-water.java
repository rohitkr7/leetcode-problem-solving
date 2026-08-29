class Solution {
    
    // Time: O(n)
    // Space: O(1)
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int currentContainerWater = 0;
        int maxWater = 0;
        while (left < right) {
            currentContainerWater = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(currentContainerWater, maxWater);
            if (height[left] < height[right])
                left++; // left side height is less so lets move ahead
            else
                right--; // right side height is less so let's go little backwards
        }
        return maxWater;
    }
}