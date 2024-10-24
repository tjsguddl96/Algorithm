class Solution {

    private int[][] dp;

    public int solution(int n, int[] money) {

        dp = new int[money.length + 1][n + 1];//이차원 배열 생성

        for (int i = 1; i <= money.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[i][j] = 1;//맨 첫 열은 1로 초기화
                } else if (j - money[i-1] >= 0) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - money[i - 1]]) % 1000000007;
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[money.length][n];
    }
}