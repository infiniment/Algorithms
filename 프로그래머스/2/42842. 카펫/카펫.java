
class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        // 노란색의 약수 쌍을 찾는다. (a, b)
        for(int h = 1; h * h <= yellow; h++) {
            if(yellow % h == 0) {
                int wInner = yellow / h;
                
                int w = wInner + 2;
                int height = h + 2;
                
                if(w * height == total) {
                    if(w >= height) {
                        return new int[]{w, height}; // 가로가 세로보다 같거나 기므로
                    }else {
                        return new int[]{height, w};
                    }
                }
            }
        }
        return new int[]{}; 
    }
}