import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        
        dfs(numbers, "", visited);

        int answer = 0;
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    // 만들 수 있는 모든 숫자 조합 생성
    public static void dfs(String numbers, String current, boolean[] visited) {
        // current가 비어있지 않으면 숫자로 변환해서 set에 저장
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

    // 소수 판별
    public static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}