class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] periods = new int[n];
        
        
        for(int i = 0; i < n; i++) {
            periods[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }
        

        int totalCycle = periods[0];
        for (int i = 1; i < n; i++) {
            totalCycle = lcm(totalCycle, periods[i]);
        }
        

        for(int t = 1; t <= totalCycle; t++) {
            boolean allYellow = true;
            
            for (int i = 0; i < n; i++) {   
                int g = signals[i][0];
                int y = signals[i][1];
                int p = periods[i];
                
                int pos = (t - 1) % p;
                

                if (!(g <= pos && pos < g + y)) {
                    allYellow = false;
                    break;
                }
            }
            
            if (allYellow) {
                return t;
            }
            
            
        }
        
        return -1;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
    
    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}