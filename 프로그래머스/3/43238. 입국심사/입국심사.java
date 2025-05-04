class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        long start = 0;
        long end = Long.MAX_VALUE;
        
        while(start <= end){
            long mid = start / 2 + end / 2;
            long result = 0;
            for(int time : times){
                result += mid / time;
                if(result >= n || result < 0){
                    break;
                }
            }
            
            if(n <= result){
                answer = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return answer;
    }
}