/*
The depth of any character in the VPS is the ( number of left brackets before it ) - ( number of right brackets before it )
*/
class Solution {
    public int maxDepth(String str) {
        int maxDepth = 0;
        int leftBrackets = 0;
        int rightBrackets = 0;
        for(Character c : str.toCharArray()) {
            // 1. get the max depth at current character
            maxDepth = Math.max(maxDepth, leftBrackets - rightBrackets);
            
            // 2. update count
            if(c == '(') leftBrackets++;
            if(c == ')') rightBrackets++;
        }
        return maxDepth;
    }
}