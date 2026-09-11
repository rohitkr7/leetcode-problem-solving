class Solution {
    // Time Complexity:
    // - Worst Case: O(S), where S is the sum of all characters across all strings (or O(N * M), 
    //   where N is the number of strings and M is the length of the shortest string).
    // - Best Case: O(N), when the first character already mismatches across strings.
    //
    // Space Complexity:
    // - Auxiliary Space: O(1), uses only constant extra memory for pointers and loop variables.
    // - Output Space: O(M), to store the returned substring prefix.
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        // Iterate through each character of the first string
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            // Compare character c with the character at index i in all other strings
            for (int j = 1; j < strs.length; j++) {
                // If index exceeds current string's length or characters mismatch
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}