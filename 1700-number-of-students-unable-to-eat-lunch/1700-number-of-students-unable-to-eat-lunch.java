class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // 1. creae queue of students
        Queue<Integer> q = new LinkedList<>();
        
        // 2. map to store refused sandwich by students
        Map<Integer, Integer> refusedMap = new HashMap<>();
        
        // 3. put students in queue
        for(int i = 0; i < students.length; i++) {
            q.add(i);
        }
        
        // 4. sandwith index
        int sandwich = 0;
        
        // 5. if same student sees sandwich refused by him earlier, we are done
        while(q.size() > 0) {  
            // 6. get front of queue
            int front = q.poll();
            
            // 7. if it already participated earlier and sees same sandwich again
            if(refusedMap.containsKey(front) && refusedMap.get(front) == sandwich) {
                return q.size() + 1;
            }
            
            // 8. check the selection of sandwich by current student, if he likes
            if(students[front] == sandwiches[sandwich]) {
                sandwich++;
            } else {
                // 9. current student don't like the sandwich at top of stack
                // put student at the back of queue
                q.add(front);
                refusedMap.put(front, sandwich);
            }
            
        }
        
        return q.size();
    }
}