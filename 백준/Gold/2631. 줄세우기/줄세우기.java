import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        arr=new int[N+1];
        dp=new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=Integer.parseInt(bf.readLine());
        }
        for(int i=1;i<N+1;i++) {
            int now = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (now > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(N-max);
    }
}
/*
7
1
3
7
6
2
4
5
->3

7
1
3
5
2
4
6
7
-> 2
=> 1 5 2 3 4 6 7 ->1 2 3 4 5 6 7

7
3
1
5
2
4
6
7
-> 2
=> 3 1 2 4 5 6 7 -> 1 2 3 4 5 6 7
* */