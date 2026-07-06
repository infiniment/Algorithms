import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int OFFSET = 1000;
        boolean[][] checked = new boolean[2001][2001];

        for (int i = 0; i < 3; i++) {
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    if (i != 2) {
                        checked[x][y] = true;
                    }else {
                        checked[x][y] = false;
                    }
                }
            }
        }

        int area = 0;
        
        for (int x = 0; x < 2001; x++) {
            for (int y = 0; y < 2001; y++) {
                if (checked[x][y]) {
                    area++;
                }
            }
        }

        System.out.println(area);
    }
}