class Solution {
    public int[][] transpose(int[][] matrix) {
        // 1. rows
        int rows = matrix.length;
        
        // 2. columns 
        int columns = matrix[0].length;
        
        // 3. transponse matrix has rows equal to columns and columns equal to rows
        int [][]transpose = new int[columns][rows];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        
        return transpose;
    }
}