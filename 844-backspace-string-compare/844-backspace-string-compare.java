/*
Using stack: Use stack to build string after doing backspace operations
*/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getStringAfterBackSpace(s).equals(getStringAfterBackSpace(t));
    }
    
    private String getStringAfterBackSpace(String s) {
        Stack<Character> st = new Stack<>();
        // do backspace operations on string
        for(char c: s.toCharArray()) {
            if(c == '#') {
                if(!st.empty())
                    st.pop();
            } else {
                st.push(c);
            }
        }
        
        // build string after backspace operations are done
        StringBuilder res = new StringBuilder();
        while(!st.empty()) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}