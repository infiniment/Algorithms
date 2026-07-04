import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a, b;


        // N칸짜리 1차원 배열을 만든다
        int[] blocks = new int[n];

        for(int i = 0; i < k; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            // A ~ B까지 count
            for(int j = a; j <= b; j++) {
                blocks[j - 1]++;
            } 
        }

        

        // 다 돌린 후에 처음부터 끝까지 순회하면서 max값 구한다
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] > max) {
                max = blocks[i];
            }
        }

        // 출력
        System.out.println(max);
    }
}