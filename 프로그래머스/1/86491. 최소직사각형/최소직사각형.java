
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int longest = 0; // 가장 긴 변 중 긴 것
        int shortestLong = 0; // 가장 짧은 변중에 긴 것
        
        
        // 가로 세로라고 생각하지 말고 가장 긴 변, 가장 짧은 변이라고 생각하기
        // 왜냐하면 모든 명함은 회전이 가능하기 때문
        // 그럼 각 명함에서 가장 긴 변을 구하고
        // 그 가장 긴 변 중 가장 긴 것을 구한다.
         // 가장 짧은 변도 마찬가지로 구한다.
        for (int i = 0; i < sizes.length; i++) {
            int longer = Math.max(sizes[i][0], sizes[i][1]);
            int shorter = Math.min(sizes[i][0], sizes[i][1]);
            
            longest = Math.max(longest, longer);
            shortestLong = Math.max(shortestLong, shorter);
            answer = longest * shortestLong;
        }
       
        
        // 그 둘을 곱한다.
        return answer;
    }
}