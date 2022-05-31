class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')  {
                st.push(i);
            } else {
                int p = st.pop();
                // primitive string found
                if(st.empty()) {
                    res.append(s.substring(p+1, i));
                }
            }
        }
        
        return res.toString();
    }
}