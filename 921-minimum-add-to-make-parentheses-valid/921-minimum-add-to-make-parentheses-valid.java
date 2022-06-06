/*
Use stack
*/
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int minMoves = 0;
        
        for(char c : s.toCharArray()) {
            if(c == ')') {
                if(st.empty()) {
                    minMoves++;
                } else {
                    st.pop();
                }
            } else {
                st.push(c);
            }
        }
        
        return minMoves + st.size();
    }
}