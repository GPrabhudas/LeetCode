class NumMatrix {
    
    // 1. auxilliary array to store prefix sums of sub matrix [0, 0] to [r, c] where  0 <= r < m, 0 <= c < n
    int res[][];
    
    // 2. number of rows in matrix
    int m;
    
    // 3. number of columns in matrix
    int n;

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        
        res = new int[m][n];
        
        // 4. compute prefix sums of submatrices
        // 4.1 copy first row 
        for(int i = 0; i < n; i++) {
            res[0][i] = matrix[0][i];
        }
        
        // 4.2 do column wise sum, ignore first row
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res[i][j] = matrix[i][j] + res[i-1][j];
            }
        }
        
        // 4.3 do row wise sum, ignore first column
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                res[i][j] += res[i][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // we can calcuate sum as follows
        // sum = res[row2][col2] - res[row-1][col1] - res[row2][col1 - 1]
        // sum = sum + res[row1-1][col1 -1] if row1 > 0 and row2 > 0, because res[row1-1][col1-1] gets substracted twice
        
        int sum = res[row2][col2]; // this will hold sum for matrix [0, 0] to [row2, col2];
        
        if(row1 > 0) {
            sum -= res[row1 -1][col2];
        }
        
        if(col1 > 0) {
            sum -= res[row2][col1 - 1];
        }
        
        if(row1 > 0 && col1 > 0) {
            sum += res[row1-1][col1-1];
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */