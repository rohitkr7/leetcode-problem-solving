class Solution {
    // Time: O(4^n / sqrt{n})
    // Space: O(n)
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, n, new StringBuilder(), result);
        return result;
    }

    private void dfs(int open, int close, int length, StringBuilder currentResult, List<String> result) {
        if (currentResult.length() == 2 * length) {
            result.add(currentResult.toString());
            return;
        }

        if (open < length) {
            currentResult.append("(");
            dfs(open + 1, close, length, currentResult, result);
            currentResult.deleteCharAt(currentResult.length() - 1);
        }

        if (close < open) {
            currentResult.append(")");
            dfs(open, close + 1, length, currentResult, result);
            currentResult.deleteCharAt(currentResult.length() - 1);
        }
    }
}