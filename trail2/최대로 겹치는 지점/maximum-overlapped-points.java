import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] checked = new int[101];
        int max = 0;
        int maxLoc = 0;

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            if (x2 > maxLoc) {
                maxLoc = x2;
            }

            for (int j = x1; j <= x2; j++) {
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