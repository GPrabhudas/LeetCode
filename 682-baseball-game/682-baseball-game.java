class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> records = new Stack<>();
        
        for(String c : ops) {
            switch(c) {
                case "+": addRecordSumPreviousTwo(records); break;
                case "D": addRecordDoubleOfPrevious(records); break;
                case "C": invalidate(records); break;
                default: addRecord(records, c);
            }
        }
        return getTotalScore(records);
    }
    
    private void addRecord(Stack<Integer> records, String c) {
        int newRecord = Integer.valueOf(c);
        records.push(newRecord);
    }
    
    private void invalidate(Stack<Integer> records) {
        records.pop();
    }
    
    private void addRecordDoubleOfPrevious(Stack<Integer> records) {
        records.push(2 * records.peek());
    }
    
    private void addRecordSumPreviousTwo(Stack<Integer> records) {
        int top1 = records.pop();
        int top2 = records.pop();
        int newRecord = top1 + top2;
        
        records.push(top2);
        records.push(top1);
        records.push(newRecord);
    }
    
    private int getTotalScore(Stack<Integer> records) {
        int sum = 0;
        while(!records.empty()) {
            sum += records.pop();
        }
        return sum;
    }
}