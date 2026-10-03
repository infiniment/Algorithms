import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; // 각 신고자들이 받을 메일 count 담을 역할 
        HashMap<String, Integer> hash = new HashMap<>(); // 각 사용자가 신고당한 횟수 세기

        HashSet<String> set = new HashSet<>();
        // 1. 중복 신고 제거
        for (int i = 0; i < report.length; i++) {
            set.add(report[i]); 
        }
        
        // 2. 각 사용자가 신고당한 횟수 세기
        // report : "신고자" "피신고자"
        // report 당한 횟수가 k 이상인지 확인 key = 해당 사용자, value = report 당한 횟수
        for (String r : set) {
            String[] people = r.split(" ");

            String reporter = people[0]; // 신고한 사람
            String reported = people[1]; // 신고당한 사람
            
            hash.put(reported, hash.getOrDefault(reported, 0) + 1);
        }
        
        
        
        // 3. 정지된 사람을 신고한 사람에게 메일 횟수 주기
        HashMap<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            indexMap.put(id_list[i], i);
        }
        
        for (String r : set) {
            String[] people = r.split(" ");
            
            String reporter = people[0]; // 신고한 사람
            String reported = people[1]; // 신고당한 사람
            
            if (hash.get(reported) >= k) {
                int index = indexMap.get(reporter);
                
                answer[index]++;
            }
            
        }
        
        return answer;
    }
}