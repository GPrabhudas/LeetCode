class Solution {
    public String removeDuplicates(String s) {
        char []chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        
        st.push(chars[0]);
        
        for(int i = 1; i < chars.length; i++) {
            if(!st.empty() && st.peek() == chars[i]) {
                while(!st.empty() && st.peek() == chars[i]) st.pop();   
            } else {
                st.push(chars[i]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.empty()) {
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}