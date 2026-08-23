class Solution {
    
    // This is Merge Sort Solution ---
    
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }
    
    public void sort(int[] arr, int l, int r){
        if(l < r){
            int mid = l + (r - l)/2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }
    public void merge(int[] arr, int l, int m, int r){
        // Find the sizes of the subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        
        // create two temp arrays
        int[] left = new int[n1];
        int[] right = new int[n2];
        
        // Copy data to subarrays
        for(int i=0; i < n1; i++){
            left[i] = arr[l+i];
        }
        
        for(int j=0; j < n2; j++){
            right[j] = arr[m+1+j];
        }
        
        // Merge to temp arrays
        int k = l;
        int i =0; int j = 0;
        while(i< n1 && j< n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        
        while(i < n1){
            arr[k] = left[i];
            k++;
            i++;
        }
        while(j < n2){
            arr[k] = right[j];
            k++;
            j++;
        }
    }
}
