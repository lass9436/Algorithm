class Solution {
    public int solution(int n, int count) {
        long[][] dp = new long[n+1][n+1];
        dp[1][1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i][j] = (dp[i-1][j-1] + 2 * (i-1) * dp[i-1][j]) % 1000000007;
            }
        }
        return (int)dp[n][count];
    }
}