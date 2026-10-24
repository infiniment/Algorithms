class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][land[0].length];

        // 1. 첫 번째 행 초기화
        for (int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }
        
        // 2. 두 번째 행부터 마지막 행까지 반복
        for (int i = 1; i < land.length; i++) {
            // 3. 현재 행에서 선택할 열 j 반복
            for (int j = 0; j < land[i].length; j++) {
                // 4. 이전 행의 모든 열 k 중
                //    j와 다른 열의 최대 누적 점수 찾기
                int max = 0;

                for (int k = 0; k < land[0].length; k++) {
                    if (j != k) {
                        max = Math.max(max, dp[i - 1][k]);
                    }
                }
                // 5. 현재 칸 점수 + 이전 최대 누적 점수 저장
                dp[i][j] = land[i][j] + max;
            }
                
        }
            

        // 6. 마지막 행의 dp 값 중 최댓값 반환
        for (int i = 0; i < dp[0].length; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        return answer;
    }
}