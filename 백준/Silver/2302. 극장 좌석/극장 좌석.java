import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static ArrayList<Integer> vips=new ArrayList<>();
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        M=Integer.parseInt(bf.readLine());
        dp=new int[41];
        for(int i=0;i<M;i++){
            vips.add(Integer.parseInt(bf.readLine()));
        }

        Collections.sort(vips);
        if(vips.isEmpty() || vips.get(vips.size()-1)!=N){
            vips.add(N+1);
        }
        if(vips.get(0)!=1){
            vips.add(0);
        }
        Collections.sort(vips);
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=40;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        int answer=1;
        for(int i=0;i<vips.size()-1;i++){
            int diff=vips.get(i+1)-vips.get(i)-1;
            answer*=dp[diff];
        }
        System.out.println(answer);

    }


}
/*
4
0


4
4
1
2
3
4
->1

9
3
1
4
7
->8
* */
