class Solution {
    // top down approach with DP memorization
    public int fib(int n) {
        int memo[] = new int[n + 1];
        return fib(n, memo);
    }
    
    private int fib(int n, int[] memo) {
        // 1.base case 
        if(n == 0 || n == 1) return n;
        
        // 2.already computed
        if(memo[n] > 0) return memo[n];
        
        // 3. not computed, compute now
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        
        return memo[n];
    }
}