class Solution {

    // Time: O(n)
    // Space: O(1) - The table requires a fixed array of size 26 (int[26]) regardless of how large $n$ grows. ince the auxiliary memory does not scale with the input size, the extra space complexity is constant, O(1)

    public boolean isAnagram_1(String s, String t) {
        int[] freqMap = new int[26];

        if (s.length() != t.length())
            return false;

        // Create the frequency map for string s by incrementing the values on respective indices
        for (char c : s.toCharArray()) {
            freqMap[c - 'a'] += 1;
        }

        // In-Place Check: Check if the char in t is already not present in the s then return false
        // Decrement all the chars which are present in the string t
        for (char c : t.toCharArray()) {
            if (freqMap[c - 'a'] == 0) {
                return false; // Character not in s, or used too many times
            }

            freqMap[c - 'a'] -= 1;
        }

        return true;
    }

    // This solves the follow up if the input contains Unicode chars
    // As of the latest standard (Unicode 17.0), there are 159,801 defined characters across 172 scripts and symbol sets.
    // Using a 26 length array is not going to solve the problem that's why we need to switch to HashMap

    // Time: O(n)
    // Space: O(k) where k is the size of unique unicode chars used as input, k <= n
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Map characters to their frequency counts
        Map<Character, Integer> counts = new HashMap<>();

        // 1. Count frequencies of characters in string s
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // 2. Decrement counts for characters in string t
        for (char c : t.toCharArray()) {
            // If the character was never in s, or we already used all occurrences
            if (!counts.containsKey(c) || counts.get(c) == 0) {
                return false;
            }
            counts.put(c, counts.get(c) - 1);
        }

        return true;
    }
}