import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[504][504];
        dp[0][0] = triangle[0][0];
        
        for(int i = 0; i < triangle.length - 1; i++) {
            for(int j = 0; j <= i; j++) {
                // 대각선 왼쪽 아래 노드 방문 경험 있음
                if(dp[i + 1][j] < dp[i][j] + triangle[i + 1][j]) {
                    dp[i + 1][j] = dp[i][j] + triangle[i + 1][j];
                } 
                if(dp[i + 1][j + 1] < dp[i][j] + triangle[i + 1][j + 1]) {
                    dp[i + 1][j + 1] = dp[i][j] + triangle[i + 1][j + 1];
                } 
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < triangle.length; i++) {
            if(max < dp[triangle.length - 1][i]) {
                max = dp[triangle.length - 1][i];
            }
        }
        
        return max;
    }
}