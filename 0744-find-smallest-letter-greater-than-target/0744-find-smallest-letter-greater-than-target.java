class Solution {
    //Time: O(n) and Space: O(1)
    public char nextGreatestLetter_1(char[] letters, char target) {

        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }

    public char nextGreatestLetter(char[] letters, char target) {
        // Input is already sorted so >> Binary Search Approach
        // Time Complexity: O(log n)
        // Space Complexity: O(1)

        int left = 0;
        int right = letters.length - 1;

        // Standard binary search for the upper bound (first element strictly greater than target)
        while (left <= right) {
            // Avoids integer overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2;

            if (letters[mid] <= target) {
                // If mid is less than or equal to target, the strictly greater element must be to the right
                left = mid + 1;
            } else {
                // If mid is strictly greater, it's a potential answer; continue searching left for an earlier candidate
                right = mid - 1;
            }
        }

        // When the loop terminates, 'left' points to the insertion index.
        // If left == letters.length (no element is greater than target), modulo wraps it back to index 0.
        return letters[left % letters.length];
    }
}