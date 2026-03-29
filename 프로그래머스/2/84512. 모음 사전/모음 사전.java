class Solution {
    public static String[] dictionary = {"A", "E", "I", "O", "U"};
    public static int count = 0;
    public static int answer = 0;

    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    
    public static void dfs(String str, String word) {
        if(!str.equals("")) {
            count++;
            
            if(str.equals(word)) {
                answer = count;
                return;
            }
        }
        
        if(str.length() == 5) return;
        
        for(int i = 0; i < dictionary.length; i++) {
            dfs(str + dictionary[i], word);
        }
    }

}