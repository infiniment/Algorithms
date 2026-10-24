import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 사람들의 몸무게를 오름차순으로 정렬
        // 선택 절차 : 몸무게가 가장 큰 사람과 가장 적게 나가는 사람을 더했을 때 제한을 넘으면 다른 사람들도 태울 수 없다.
        // 적절성 검사 : 최대와 최소가 더했을 때 제한을 안 넘으면 두 명을 태울 수 있음, 초과면 무거운 사람만 혼자 태운다.
        // 해답 검사 : 남은 사람 없이 다 보트에 태웠는지?, 보트를 출발시킬 때마다 개수를 정확히 하나씩 증가시켰는가?
        
        Arrays.sort(people);
        
        int left = 0; // 가벼운 사람
        int right = people.length - 1; // 무거운 사람
        
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                answer++;
                left++;
                right--;
            } else {
                right--;
                answer++;
            }
        }
        
        return answer;
    }
}