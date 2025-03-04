import java.util.*;
import java.io.*;

public class Main {
    static int T,N;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++) {
            N = Integer.parseInt(bf.readLine());
            map = new int[2][N];
            dp = new int[2][N];

            StringTokenizer st;
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];
            int tmp0 = 0;
            int tmp1 = 0;
            int tmp = 0;
            for (int j = 1; j < N; j++) {
                if (j > 1) {
                    tmp = Math.max(tmp, dp[0][j - 2]);
                    tmp = Math.max(tmp, dp[1][j - 2]);
                }
                //0행
                tmp0 = Math.max(tmp0, dp[1][j - 1]);
                dp[0][j] = Math.max(tmp0, tmp) + map[0][j];
                //1행
                tmp1 = Math.max(tmp1, dp[0][j - 1]);
                dp[1][j] = Math.max(tmp1, tmp) + map[1][j];
                tmp = 0;
                tmp0 = 0;
                tmp1 = 0;
            }

            answer.append(Math.max(dp[0][N - 1], dp[1][N - 1]) + "\n");
        }


        bw.flush();
        bw.write(answer.toString());
        bw.close();

    }
}

/*
1
3
1 100 100
1 0 0
->101

1
3
21 69 96
81 50 24
->177

3
6
10 40 70 80 90 150
50 20 80 160 20 10
8
9 1 8 3 4 7 0 4
0 0 0 0 0 0 0 0
10
100 99 100 99 100 100 100 100 99 99
99 99 99 100 100 100 100 99 99 99
Output
430
28
996

1
3
60 0 0
0 100 60
answer:160

* */