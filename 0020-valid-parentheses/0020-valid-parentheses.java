import java.util.Stack;

class Solution {

    // Time: O(n) and Space: O(n) space stack
    public boolean isValid_1(String s) {

        // Fast exit: odd length can never be balanced
        if (s.length() % 2 != 0) {
            return false;
        }

        HashMap<Character, Character> bracketPair = new HashMap<Character, Character>();
        bracketPair.put(')', '(');
        bracketPair.put('}', '{');
        bracketPair.put(']', '[');

        Stack<Character> st = new Stack<Character>();
        char top;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (!st.isEmpty()) {
                    top = st.peek();
                    if (top == bracketPair.get(c)) {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return st.size() == 0;
    }

    public boolean isValid(String s) {
        // Fast exit: odd length can never be balanced
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}