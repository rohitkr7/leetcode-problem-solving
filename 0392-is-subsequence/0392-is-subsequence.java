class Solution {
    //Time: O(n) and Space: O(1)
    public boolean isSubsequence(String s, String t) {
        if (s.equals(t) || s.length() == 0)
            return true;

        if (s.length() > t.length())
            return false;

        // i means the i-th index of s
        // j means the j-th index of t
        int i = 0;
        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == s.length();
    }
}