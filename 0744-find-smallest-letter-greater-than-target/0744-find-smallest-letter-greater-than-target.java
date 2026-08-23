class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char result = '\0';
        for(char c : letters){
            if(c > target){
                result = c;
                break;
            }
        }
        if(result == '\0')
            result = letters[0];
        return result;
    }
}