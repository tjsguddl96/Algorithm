import java.util.*;
import java.io.*;
public class Main {
    static int[] a;
    static int answer;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        a=new int[3];
        dp=new int[1001][1001];
        int s=0;
        for(int i=0;i<3;i++){
            a[i]=Integer.parseInt(st.nextToken());
            s+=a[i];
        }
        if(s%3==0) {
            solve(a);
        }
        System.out.println(answer);
    }

    public static void solve(int[] arr) {
        if(arr[0]==arr[1] && arr[0]==arr[2]){
            answer=1;
            return ;
        }
        if(answer==1){
            return ;
        }
        int[] b=new int[3];
        for(int i=0;i<3;i++){
            b[i]=arr[i];
        }
        for(int i=0;i<3;i++){
            for(int j=i+1;j<3;j++){
                int min=Math.min(arr[i],arr[j]);
                int max=Math.max(arr[i],arr[j]);
                int tmp1=min*2;
                int tmp2=max-min;
                if(tmp2<1001 && tmp2>0 && tmp1<1001 && tmp2>0 && dp[tmp1][tmp2]==0){
                    dp[tmp1][tmp2]=1;
                    arr[i]=tmp1;
                    arr[j]=tmp2;
                    solve(arr);
                    arr[i]=b[i];
                    arr[j]=b[j];
                }
            }
        }

    }

}