class Solution {
    public int minOperations(String[] logs) {
        Stack<String> s = new Stack<>();
        
        for(String log : logs) {
            switch(log) {
                case "../": 
                    if(!s.empty()) s.pop();
                    break;
                case "./": 
                    break; 
                default: s.push(log);break;
            }
        }
        
        return s.size();
    }
}