class Solution {
    public String makeGood(String s) {
        // 1. create stack of Characters and process every character of string
        Stack<Character> st = new Stack<>();
        
        // 2. get chars of string
        char[] chars = s.toCharArray();
        
        // 3. push first character to stack
        st.push(chars[0]);
        
        // 4. process remaining characters one by one
        for(int i = 1; i < chars.length; i++) {
            // 5. check if adding current charcter makes string bad
            if(!st.empty() && st.peek() != chars[i] && Character.toUpperCase(chars[i]) == Character.toUpperCase(st.peek())) {
                // adding this character makes string bad, remove top of the stack
                st.pop();
            } else {
                // 6. so far string is not bad, add current character to stack
                st.push(chars[i]);
            }
        }
        
        // 7. build result string using chars in stack
        StringBuilder res = new StringBuilder();
        while(!st.empty()) {
            res.append(st.pop());
        }
        
        return res.reverse().toString();
    }
}