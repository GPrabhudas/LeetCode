class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        for(int j = 0; j < prices.length; j++) {
            while(!s.empty() && prices[j] <= prices[s.peek()]) {
                prices[s.peek()] = prices[s.peek()] - prices[j];
                s.pop();
            }
            s.push(j);
        }
        
        return prices;
    }
}