class Solution {
    public void rotate(int[][] matrix) {
        // Bruteforce can be done by taking an additonal matrix and storing all the rows of the original matrix to the respective columns
        
        // Second optimized approach is to Transposing the matrix and then reverse the elements of each rows and this is in-place solution
        transposeMatrix(matrix);
        //print(matrix);
        for(int i=0; i< matrix.length; i++){
            reverseRow(matrix[i]);
        }
        
        print(matrix);
        
    }
    
    public void transposeMatrix(int[][] matrix){
        for(int i=0; i< matrix.length; i++){
            for(int j=i; j< matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] =  matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //print(matrix);
        //return matrix;
        
    }
    
    public void print(int[][] matrix){
        // print elements
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix.length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println() ;
        }
    }
    public void reverseRow(int[] arr){
        int start = 0; int end = arr.length -1;
        int temp = 0;
        
        while(start<end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}