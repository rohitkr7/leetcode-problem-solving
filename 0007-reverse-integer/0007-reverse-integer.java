class Solution {
    public int reverse(int x) {

        if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE)
            return 0;

        long reverse = 0L;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
            if (reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE)
                return 0;
        }

        return (int) reverse;
    }
}