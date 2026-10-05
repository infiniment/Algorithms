import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 큐에 저장할 때는 우선순위만 넣으면 나중에 location을 알기 어려워 지므로 배열 타입의 큐를 만든다.
        Deque<int[]> deque = new ArrayDeque<>();
        
        // 큐에 담는 과정이 먼저
        for (int i = 0; i < priorities.length; i++) {
            deque.addLast(new int[]{priorities[i], i});
        }
        
        /*
        1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다. 
        2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
        3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
          3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
        */
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst(); // 맨 앞에 있는 프로세스 꺼내기
            
            boolean hasHigher = false;
            
            for (int[] process : deque) {
                if (current[0] < process[0]) {
                    hasHigher = true;
                    break;
                }
            }
            
            if (hasHigher) {
                deque.addLast(current);
            } else {
                answer++;
                
                if (current[1] == location) {
                    return answer;
                }
            }
        }
        
        
        return answer;
    }
}