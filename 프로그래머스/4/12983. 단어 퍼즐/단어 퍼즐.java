import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int len = t.length();
        int[] dp = new int[len+1];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;
        
        for(int i=1; i<=len; i++){
            String cur = t.substring(0, i);     
            for(int j=0; j<strs.length; j++){
                String str = strs[j];
                if(cur.endsWith(str)){
                    int diff = cur.length() - str.length();             
                    if(diff >= 0){
                        dp[i] = Math.min(dp[i], dp[diff] + 1);
                    }
                }
            }
        }

        return dp[len] == 987654321 ? -1 : dp[len];
    }
}