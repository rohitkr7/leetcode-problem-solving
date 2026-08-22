class Solution {
    public boolean containsDuplicate(int[] nums) {

        // Time: O(n)
        // Space: O(n)
        HashSet hs = new HashSet<Integer>();

        for(int i : nums){
            if(hs.contains(i))
                return true;
            else
            hs.add(i);
        }

        return false;
    }
}
