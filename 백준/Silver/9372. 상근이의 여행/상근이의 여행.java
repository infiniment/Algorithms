import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        // t만큼 반복
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 간선 정보 M개 입력만 받고 사용하지 않음
            for (int j = 0; j < m; j++) {
                bf.readLine();
            }

            sb.append(n - 1).append("\n");
        }

        System.out.print(sb);
    }
}