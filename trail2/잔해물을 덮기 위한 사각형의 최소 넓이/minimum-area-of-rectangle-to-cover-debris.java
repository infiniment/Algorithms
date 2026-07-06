import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int OFFSET = 1000;
        boolean[][] checked = new boolean[2001][2001];

        for (int i = 0; i < 2; i++) {
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    if (i == 0) {
                        checked[x][y] = true;  
                    } else {
                        checked[x][y] = false;  
                    }
                }
            }
        }

        int minX = 2001;
        int maxX = -1;
        int minY = 2001;
        int maxY = -1;

        for (int x = 0; x < 2001; x++) {
            for (int y = 0; y < 2001; y++) {
                if (checked[x][y]) {
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        if (maxX == -1) {
            System.out.println(0);
        } else {
            int width = maxX - minX + 1;
            int height = maxY - minY + 1;

            System.out.println(width * height);
        }
    }
}