class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        List<Integer> prev, curr = null;
        prev = new ArrayList<Integer>();
      
        for(int i=0; i<numRows; i++){
            curr = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                if(j == 0 || j == i )
                    curr.add(1);
                else
                    curr.add(prev.get(j-1) + prev.get(j));
            }
                prev = curr;
                listOfLists.add(curr);
        }
        return listOfLists;
    }
}