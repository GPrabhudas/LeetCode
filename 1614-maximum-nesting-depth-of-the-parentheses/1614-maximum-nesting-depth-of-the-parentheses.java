class Solution {
    public int maxDepth(String str) {
        Stack<Character> s = new Stack<>();
        int maxDepth = 0;
        int length = 0;
        for(Character c : str.toCharArray()) {
            if(c == '(') {
                s.push('(');
                length++;
            } else if(c == ')') {
                s.pop();
                maxDepth = Math.max(maxDepth, length);
                length--;
            } else {
                maxDepth = Math.max(maxDepth, length);
            }
        }
        return maxDepth;
    }
}