import java.io.*;
import java.util.*;
public class Main {
    static int N,M,H;
    static ArrayList<Integer>[] arr;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        dp=new int[N+1][M+1][H+1];
        for(int i=0;i<N+1;i++){
            arr[i]=new ArrayList<>();
            arr[i].add(0);
            if(i==0){
                continue;
            }
            st=new StringTokenizer(bf.readLine());
            while(st.hasMoreTokens()){
                int input=Integer.parseInt(st.nextToken());
                arr[i].add(input);
            }
        }
        dp[0][0][0]=1;
        for(int i=1;i<N+1;i++){
            for(int j=0;j<M+1;j++){
                dp[i][j][0]=1;
            }
            Collections.sort(arr[i]);
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<arr[i].size();j++){
                int now=arr[i].get(j);
                for(int k=1;k<H+1;k++) {
                    if(j==1){
                        if(k>=now){
                            dp[i][j][k]+=(dp[i-1][arr[i-1].size()-1][k-now]%10007);
                        }

                        dp[i][j][k]+=(dp[i-1][arr[i-1].size()-1][k]%10007);

                    }
                    else{
                        if(k>=now){
                            dp[i][j][k]+=(dp[i-1][arr[i-1].size()-1][k-now]%10007);
                        }
                        dp[i][j][k]+=(dp[i][j-1][k]%10007);
                    }
                }
            }
        }
//        for(int i=1;i<N+1;i++){
//            System.out.println(i);
//            for(int j=1;j<M+1;j++){
//                for(int k=1;k<H+1;k++){
//                    System.out.print(dp[i][j][k]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
        System.out.println(dp[N][M][H]%10007);

    }
}
/*
4 3 5
2 3 5
5
3 5
1 2 3
* */