
import java.util.*;

class Solution {
    public static boolean[] visited;
    public static int min = Integer.MAX_VALUE;
        
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int i = 0; i < wires.length; i++) {
            int cutA = wires[i][0];
            int cutB = wires[i][1];
            
            visited = new boolean[n + 1];
            
            int count = dfs(1, cutA, cutB, graph);
            int diff = Math.abs(count - (n - count));
            
            min = Math.min(min, diff);
        }
        
        return min;
        
    }
    
    public static int dfs(int now, int cutA, int cutB, List<Integer>[] graph) {
        visited[now] = true;
        int count = 1;
        
        for(int next : graph[now]) {
            if(visited[next]) continue;
            
            if((now == cutA && next == cutB) || (now == cutB && next == cutA)) {
                continue;
            }
            
            count += dfs(next, cutA, cutB, graph);
        }
        return count;
    }
}