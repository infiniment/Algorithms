import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int OFFSET = 100;
        int n = sc.nextInt();

        boolean[][] checked = new boolean[201][201];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;

            if (i % 2 == 0) {
                for (int x = x1; x < x2; x++) {
                    for (int y = y1; y < y2; y++) {
                        checked[x][y] = false;
                    }
                }
            }else {
                for (int x = x1; x < x2; x++) {
                    for (int y = y1; y < y2; y++) {
                        checked[x][y] = true;
                    }
                }
            }
        }
        int area = 0;

        for (int x = 0; x < 201; x++) {
            for (int y = 0; y < 201; y++) {
                if (checked[x][y]) {
                    area++;
                }
            }
        }

        System.out.println(area);
    }
}