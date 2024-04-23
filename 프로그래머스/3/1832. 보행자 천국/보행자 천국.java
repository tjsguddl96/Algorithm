import java.util.*;

class Solution {
    int MOD = 20170805;
    int[] dy={0,-1};
    int[] dx={-1,0};
    int[][][] dp;
    class Position{
        int y;
        int x;
        public Position(int y,int x,int dir){
            this.y=y;
            this.x=x;
        }
    }
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        dp=new int[m][n][2];
        for(int i=0;i<n;i++){
            if(cityMap[0][i]==1){
                break;
            }

            dp[0][i][0]=1;
            dp[0][i][1]=0;
            
        }
        for(int i=0;i<m;i++){
            if(cityMap[i][0]==1){
                break;
            }
            dp[i][0][0]=0;
            dp[i][0][1]=1;
            
        }
        
        for(int y=1;y<m;y++){
            for(int x=1;x<n;x++){
                
                for(int dir=0;dir<2;dir++){
                    int prevY=y+dy[dir];
                    int prevX=x+dx[dir];
                    if(cityMap[prevY][prevX]==0){
                        dp[y][x][dir]+=(dp[prevY][prevX][0]%MOD+dp[prevY][prevX][1]%MOD)%MOD;
                    }
                    else if(cityMap[prevY][prevX]==2){
                        dp[y][x][dir]+=(dp[prevY][prevX][dir]%MOD)%MOD;
                    }
                }
            }
        }
        
        answer=(dp[m-1][n-1][0]%MOD+dp[m-1][n-1][1]%MOD)%MOD;
        return answer;
    }
    
}