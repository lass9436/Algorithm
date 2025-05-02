import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        
        System.out.println(Arrays.toString(citations));
        
        for(int i=n-1; i>=0; i--){
            int number = citations[i];
            int count = n - i;    
            answer = Math.max(answer, Math.min(number, count));
        }
        
        return answer;
    }
}