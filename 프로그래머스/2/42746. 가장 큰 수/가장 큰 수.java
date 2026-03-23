import java.util.Arrays;
class Solution {
    public String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];
        
        // 숫자를 문자로 변환
        for(int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }
        
        // 해당 문자를 합쳤을 때 (a + b)가 큰지 (b + a)가 큰지 비교 + 정렬
        Arrays.sort(stringNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        
        // 만약 가장 큰 값이 "0"인 경우
        if (stringNumbers[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str : stringNumbers) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}