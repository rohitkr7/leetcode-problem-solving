class Solution {

    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        Map<Integer, Integer> hm = new HashMap<>();
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            int count = hm.getOrDefault(num, 0) + 1;
            if (count > majorityCount) {
                return num;
            }
            hm.put(num, count);
        }

        return -1;
    }

    // same solution with two iterations - not suggested to be used
    public int majorityElement_1(int[] nums) {
        // Finding frequency using HashMap
        // Time: O(n)
        // Space: O(n)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (hm.containsKey(i)) {
                hm.put(i, hm.get(i) + 1);
            } else {
                hm.put(i, 1);
            }
        }

        int maxKey = 0;
        int maxVal = 0;
        // Finding the most repeated/frequent number
        for (int key : hm.keySet()) {
            if (hm.get(key) > maxVal) {
                maxKey = key;
                maxVal = hm.get(key);
            }
        }

        return maxKey;
    }

    // Optimal Alternative: Boyer-Moore Voting Algorithm
    // Time: O(n) and Space: O(1)
    /*
    The Boyer-Moore Voting Algorithm finds the majority element by pairing up distinct elements and canceling them out.Since the majority element appears strictly more than $\lfloor n / 2 \rfloor$ times, it occurs more frequently than all other elements combined. Even if every non-majority element cancels out one instance of the majority element, the majority element will still remain at the end.
    Core Rules
    Maintain two variables: a candidate and a count.
    Reset: If count == 0, pick the current element as the new candidate.Vote: If the current element equals the candidate, increment count by $1$.
    Cancel: If the current element is different, decrement count by $1$.
    */
    public int majorityElement_2(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}