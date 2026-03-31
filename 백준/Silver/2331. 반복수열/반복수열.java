import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int num = a;
        int idx = 0;

        while(true) {
            if (map.containsKey(num)) {
                System.out.println(map.get(num));
                break;
            }

            map.put(num, idx);
            idx++;
            num = nextNumber(num, p);
        }
    }

    public static int nextNumber(int num, int p) {
        int sum = 0;

        while(num > 0) {
            int digit = num % 10;
            sum += (int) Math.pow(digit, p);
            num /= 10;
        }

        return sum;
    }

}
