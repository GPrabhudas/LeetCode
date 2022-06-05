/*
Using Stack
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            // bracket is open
            if(isOpenBracket(c)) {
                // add to stack
                st.push(c);
            } else {
                // close bracket
                // if no open brackets, paranthesis is invalid
                if(st.empty()) return false;
                
                // if top of the stack is not matching open bracket
                if(!isMatchingOpenBracket(st.pop(), c)) return false;
            }
        }
        return st.empty();
    }
    
    private boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }
    
    private boolean isMatchingOpenBracket(char open, char close) {
        switch(close) {
            case ')': return open == '(';
            case ']': return open == '[';
            case '}': return open == '{';
        }
        return false;
    }
}