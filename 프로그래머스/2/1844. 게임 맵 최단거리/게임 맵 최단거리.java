import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        Deque<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            int distance = node[2];
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny, distance + 1});
                        visited[nx][ny] = true;
                        
                        if (nx == n - 1 && ny == m - 1) {
                            return distance + 1;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}