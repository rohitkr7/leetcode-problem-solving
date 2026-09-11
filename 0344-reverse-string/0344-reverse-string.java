
class Solution {
    /**
    * Time Complexity:  O(n) - Iterates through half the array (n / 2 iterations), 
    * performing O(1) swap operations at each step.
    * Space Complexity: O(1) - Only two pointer variables and one temporary char 
    * variable are allocated, satisfying in-place constraints.
    */
    public void reverseString(char[] s) {
        // Left pointer starts at the first character
        int left = 0;
        // Right pointer starts at the last character
        int right = s.length - 1;

        // Converge toward the center, swapping opposite pairs
        while (left < right) {
            // Swap characters at left and right indices
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // Advance pointers inward
            left++;
            right--;
        }
    }
}