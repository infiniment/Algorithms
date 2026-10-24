import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 1. 그래프 생성 (인접 리스트)
        List<int[]>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. 양방향 도로 저장
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int time = r[2];

            graph[a].add(new int[]{b, time});
            graph[b].add(new int[]{a, time});
        }

        // 3. 다익스트라 실행
        int[] dist = dijkstra(graph, N);

        // 4. K시간 이하로 도달 가능한 마을 계산
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    public int[] dijkstra(List<int[]>[] graph, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        // 1번 마을에서 시작
        dist[1] = 0;
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int currentCity = current[0];
            int currentTime = current[1];

            // 이미 더 짧은 경로가 존재하면 건너뛰기
            if (currentTime > dist[currentCity]) {
                continue;
            }

            // 현재 마을과 연결된 모든 도로 탐색
            for (int[] next : graph[currentCity]) {
                int nextCity = next[0];
                int roadTime = next[1];

                // 새로운 누적 이동 시간
                int newTime = currentTime + roadTime;

                // 기존 최단 시간보다 짧다면 갱신
                if (newTime < dist[nextCity]) {
                    dist[nextCity] = newTime;
                    pq.offer(new int[]{nextCity, newTime});
                }
            }
        }

        return dist;
    }
}