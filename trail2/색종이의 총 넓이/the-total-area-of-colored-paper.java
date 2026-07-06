import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int OFFSET = 100;
        int SIZE = 8;
        int n = sc.nextInt();

        boolean[][] checked = new boolean[201][201];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            
            for (int x = x1; x < x1 + 8; x++) {
                for (int y = y1; y < y1 + 8; y++) {
                    checked[x][y] = true;
                }
            }
        }
        
        int area = 0;

        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (checked[i][j]) {
                    area++;
                }
            }
        }

        System.out.println(area);
    }
}