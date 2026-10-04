import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        
        // 큐가 있다고 가정하고 하나씩 꺼냈을 때 큐에 있는 것들 중 현재 꺼낸 것보다 우선순위가 높은게 있다면 다시 큐에 넣는다.
        for (int i = 0; i < priorities.length; i++) {
            deque.addLast(new int[]{priorities[i], i});
        }
    
        
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            
            boolean hasHigher = false;

            // 큐 안에 더 높은 우선순위가 있는지 검사
            for (int[] process : deque) {
                if (current[0] < process[0]) {
                    hasHigher = true;
                    break;
                }
            }
            
            if (hasHigher) {
                // 다시 뒤에 넣기
                deque.addLast(current);
            } else {
                // 실행됐으므로 answer 증가
                answer++;

                // 방금 실행한 프로세스의 원래 위치가 location이라면?
                if (current[1] == location) {
                    return answer;
                }
            }
        }
        return answer;
    }
}