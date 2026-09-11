class Solution {

    // Time Complexity:
    // - Worst Case: O(N), where N is the length of string s (e.g., when the only word is at the start, or trailing spaces dominate).
    // - Best Case: O(K), where K is the length of the last word (when there are no trailing spaces).
    //
    // Space Complexity:
    // - Auxiliary Space: O(1), operates in-place using constant extra space (only pointers and counter variables).
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Step 1: Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    // Why lengthOfLastWord_1 is sub-optimal:
    // 1. High Memory & Allocation Overhead: s.split(" ") scans the entire string and allocates 
    //    a full String[] array on the heap (O(N) space), which is unnecessary when only the last word matters.
    // 2. Redundant Computation: Calls s.split(" ") twice, compiling regex and re-allocating the array each time.
    public int lengthOfLastWord_1(String s) {
        return s.split(" ")[s.split(" ").length - 1].length();
    }
}