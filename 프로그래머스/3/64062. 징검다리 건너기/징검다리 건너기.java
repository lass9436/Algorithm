class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int start = 0;
        int end = Integer.MAX_VALUE;
        
        while(start<=end){
            int mid = start + (end - start) / 2;
            if(isPossible(mid, k, stones)){
                start = mid + 1;
                answer = mid;
            }else{
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(int mid, int k, int[] stones){
        int temp = k;
        for(int stone : stones){
            if(stone < mid){
                temp--;
            }else{
                temp = k;
            }
            
            if(temp <= 0) return false;
        }
        return true;
    }
}