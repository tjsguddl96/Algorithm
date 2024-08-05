import java.util.*;
import java.io.*;
public class Main {
    static int T,W;
    static int[] t;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        T=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        t=new int[T+1];
        dp=new int[T+1][3][W+1]; //dp[idx][포지션][이동 횟수]
        for(int i=0;i<T+1;i++){
            for(int k=1;k<3;k++){
                for(int j=0;j<W+1;j++){
                    dp[i][k][j]=-1;
                }
            }
        }
        for(int i=1;i<T+1;i++){
            t[i]=Integer.parseInt(bf.readLine());
        }
        System.out.println(solve(1,0,0));
    }
    public static int solve(int nowPosition,int cnt,int idx){
        if(idx==T){
            if(t[idx]==nowPosition){
                dp[idx][nowPosition][cnt]=1;
                return 1;
            }
            else{
                dp[idx][nowPosition][cnt]=0;
                return 0;
            }
        }
        if(dp[idx][nowPosition][cnt]!=-1){
            return dp[idx][nowPosition][cnt];
        }
        int tmp=0;
        if(nowPosition==1){
            tmp=solve(1,cnt,idx+1);
            dp[idx][nowPosition][cnt]+=solve(1,cnt,idx+1);
            if(cnt<W) {
                tmp=Math.max(tmp,solve(2, cnt + 1, idx + 1));
            }
        }
        else{
            tmp=solve(2,cnt,idx+1);
            if(cnt<W) {
                tmp= Math.max(solve(1, cnt + 1, idx + 1),tmp);
            }
        }
        if(t[idx]==nowPosition){
            dp[idx][nowPosition][cnt]=tmp+1;
        }
        else{
            dp[idx][nowPosition][cnt]=tmp;
        }
        return dp[idx][nowPosition][cnt];
    }
}
/*
5 1
2
2
2
2
2

* */