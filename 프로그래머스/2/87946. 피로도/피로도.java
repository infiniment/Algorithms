class Solution {
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        // DFS
        // 현재 피로도, 몇 개 탐색했는지 어떤 던전을 이미 갔는지
        // 매 단계마다 방문 안 한 던전들 중 현재 피로도 >= 최소 필요 필요도인 던전만 입장 가능
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        
        for(int i = 0; i < dungeons.length; i++) {
            int need = dungeons[i][0]; // 필요한 피로도
            int use = dungeons[i][1]; // 사용해야 하는 필요도
            
            // 방문하지 않았고, 현재 필요도가 필요한 필요도보다 크거나 같아야된다.
            if(!visited[i] && k >= need) {
                visited[i] = true;
                dfs(k - use, dungeons, count + 1);
                visited[i] = false;
            }
        }
    }
}