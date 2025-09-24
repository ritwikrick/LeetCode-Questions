class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix.length;j++){
        //         if(matrix[i][j]==target){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0, right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n]; // convert 1D index to 2D
            
            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;

    }
}