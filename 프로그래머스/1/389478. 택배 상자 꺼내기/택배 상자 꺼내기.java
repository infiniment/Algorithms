class Solution {
    public int solution(int n, int w, int num) {
        int row = (num - 1) / w; // 현재 층
        int index = (num - 1) % w; // 현재 층에서 있는 위치
        int col;
        int answer = 0;
        
        if(row % 2 == 0) {
            col = index;
        }else {
            col = w - 1 - index;
        }
        
        int maxRow = (n - 1) / w;
        
        for(int i = row; i <= maxRow; i++) {
            int box;
            

            if (i % 2 == 0) {
                box = i * w + col + 1;
            }else {
                box = i * w + (w - col);
            }
            
          
            if (box <= n) {
                answer++;
            }
        }
        
        
        
        return answer;
    }
}