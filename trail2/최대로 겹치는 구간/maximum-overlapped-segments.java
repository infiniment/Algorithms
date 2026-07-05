import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int OFFSET = 100;

        int n = sc.nextInt();

        int[] checked = new int[201];
        int max = 0;
        int maxLoc = OFFSET;

        for (int i = OFFSET; i < n + OFFSET; i++) {
            int x1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;

            if (x2 > maxLoc) {
                maxLoc = x2;
            }

            for (int j = x1; j <= x2 - 1; j++) {
                checked[j]++;
            }
        }

        for (int i = 0; i < maxLoc; i++) {
            if (checked[i] > max) {
                max = checked[i];
            }
        }

        System.out.println(max);
    }
}