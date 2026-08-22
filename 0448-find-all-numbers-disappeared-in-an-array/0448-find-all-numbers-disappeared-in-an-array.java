class Solution {
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        // Solution using a HashSet
        // Time: O(n)
        // Space: O(n)
        List<Integer> disappearedNumbers = new ArrayList<Integer>();
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int num : nums) {
            numsSet.add(num);
        }

        for (int i = 1; i < nums.length + 1; i++) {
            if (!numsSet.contains(i))
                disappearedNumbers.add(i);
        }
        return disappearedNumbers;
    }

    // Solution without extra space usage
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // In place array manipulation/ Index as HashMap
        // Time: O(n)
        // Space: O(1) 
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}