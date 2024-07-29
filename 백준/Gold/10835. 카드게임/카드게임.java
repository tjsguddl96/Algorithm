import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] left;
    static int[] right;
    static long[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        left=new int[N];
        right=new int[N];
        dp=new long[N][N];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            left[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            right[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                dp[i][j]=-1;
            }
        }
        solve(0,0);
        if(dp[0][0]==0){
            System.out.println(0);
        }
        else {
            System.out.println(dp[0][0]);
        }
    }
    public static long solve(int leftIdx,int rightIdx){
        if(leftIdx==N || rightIdx==N){
            return 0;
        }
        if(dp[leftIdx][rightIdx]!=-1){
            return dp[leftIdx][rightIdx];
        }
        dp[leftIdx][rightIdx]=Math.max(dp[leftIdx][rightIdx],solve(leftIdx+1,rightIdx));
        dp[leftIdx][rightIdx]=Math.max(dp[leftIdx][rightIdx],solve(leftIdx+1,rightIdx+1));
        if(left[leftIdx]>right[rightIdx]) {
            dp[leftIdx][rightIdx] = Math.max(dp[leftIdx][rightIdx], right[rightIdx] + solve(leftIdx, rightIdx + 1));
        }
        return dp[leftIdx][rightIdx];
    }
}
/*

7
2 9 5 5 9 4 3
3 9 3 5 10 6 9
->12

2
8 4
9 7
-> 0

2
1 4
3 2
->5
* */