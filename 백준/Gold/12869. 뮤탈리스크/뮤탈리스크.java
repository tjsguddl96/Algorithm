import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] power={-9,-3,-1};
    static int[] scvs;
    static int[][][] dp;
    static ArrayList<ArrayList<Integer>> combi;
    static int[] ch;
    static int[] res=new int[3];
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        scvs=new int[3];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            scvs[i]=Integer.parseInt(st.nextToken());
        }
        combi=new ArrayList<>(new ArrayList<>());
        ch=new int[4];
        permu(0);
        dp=new int[61][61][61];
        for(int i=0;i<61;i++){
            for(int j=0;j<61;j++){
                for(int k=0;k<61;k++){
                    dp[i][j][k]=Integer.MAX_VALUE;
                }
            }
        }
        dp[scvs[0]][scvs[1]][scvs[2]]=0;
        solve(scvs[0],scvs[1],scvs[2]);
        System.out.println(dp[0][0][0]);
    }
    public static void permu(int cnt){
        if(cnt==3){
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<3;i++){
                list.add(res[i]);
            }
            combi.add(list);
            return ;
        }
        for(int i=0;i<3;i++){
            if(ch[i]==0){
                ch[i]=1;
                res[cnt]=i;
                permu(cnt+1);
                ch[i]=0;
            }
        }
    }
    public static void solve(int s1,int s2,int s3){
        for(int i=0;i<6;i++){
            int nextS1=Math.max(s1+power[combi.get(i).get(0)],0);
            int nextS2=Math.max(s2+power[combi.get(i).get(1)],0);
            int nextS3=Math.max(s3+power[combi.get(i).get(2)],0);
            if(dp[nextS1][nextS2][nextS3]>dp[s1][s2][s3]+1){
                dp[nextS1][nextS2][nextS3]=dp[s1][s2][s3]+1;
                solve(nextS1,nextS2,nextS3);
            }
        }
    }
}