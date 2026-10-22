class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        
        for (int h = 3; h <= Math.sqrt(sum); h++) {
            if (sum % h == 0) {
                int w = sum / h;
                
                if ((h - 2) * (w - 2) == yellow) {
                    return new int[]{w, h};
                }
            }    
        }
        
        return new int[]{};
    }
}