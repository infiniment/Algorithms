import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> resultArray = new ArrayList<>();
        Deque<Integer> deployment = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                day++;
            } 
            deployment.addLast(day);
        }
        
       
        
        while (!deployment.isEmpty()) {
            int currentLimit = deployment.pollFirst();
            int count = 1;
            
            while (!deployment.isEmpty() && deployment.peekFirst() <= currentLimit) {
                count++;
                deployment.pollFirst();
            }
            resultArray.add(count);
        }
        
        return resultArray.stream().mapToInt(i->i).toArray();
    }
}