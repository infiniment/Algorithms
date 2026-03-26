import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            boolean[] visited = new boolean[26]; // a to z visited;
            boolean flag = true; //
            char prev = word.charAt(0); // 기본 값은 단어 첫 글자 -> 이건 이미 방문했다 보는 것

            visited[prev - 'a'] = true; // 해당 알파벳은 방문한 걸로 하는 것

            // 첫 문자 빼고 그 다음부터
            for (int j = 1; j < word.length(); j++) {
                char current = word.charAt(j);

                // 이전 문자와 같으면 계속 진행
                if (current == prev) {
                    continue;
                }

                // 이전 글자와 같지 않은데 방문했다면 순환 종료
                if (visited[current - 'a']) {
                    flag = false;
                    break;
                }

                // 처음 나온 문자면 체크
                visited[current - 'a'] = true;
                prev = current;
            }
            if (flag) {
                count++;
            }
        }
        System.out.println(count);
    }
}
