class Solution {

    // Approach 1 - Using two stacks - Most intuitive and clean way to simulate the typing process
    // Iterate left to right. Push non-# characters; pop when encountering # (if the stack is non-empty). Compare the final stacks.
    // Time: O(m+n) and Space: O(m+n)

    public boolean backspaceCompare_1(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        return String.valueOf(stack);
    }

    //-----------------------------------------------------------
    // Approach 2 - Using reverse traversal/Two pointesr approach
    // Accumulate backspaces - there could be multiple backspaces at single place too, use counter
    // compare on the fly
    // Time: O(m+n) and space: O(1)
    public boolean backspaceCompare(String s, String t) {

        int i = s.length() - 1;
        int j = t.length() - 1;

        int skipS = 0;
        int skipT = 0;
        while (i >= 0 || j >= 0) {
            // Find next valid char in s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            // Find next valid char in t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            // Compare characters
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            // One string finished while the other still has valid characters
            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}