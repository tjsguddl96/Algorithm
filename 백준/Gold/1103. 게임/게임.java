import java.io.*;
import java.util.*;
public class Main {
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static int N,M;
    static int[][] map;
    static long[][] ch;
    static int[][] visited;
    static long answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        visited=new int[N][M];
        ch=new long[N][M];
        for(int i=0;i<N;i++){
            String input=bf.readLine();
            for(int j=0;j<M;j++){
                char C=input.charAt(j);
                if(C=='H'){
                    map[i][j]=-1;
                }
                else {
                    map[i][j] = C - '0';
                }
            }
        }
        ch[0][0]=1;
        visited[0][0]=1;
        dfs(0,0,1);
        System.out.println(answer);
    }
    public static void dfs(int nowY,int nowX,long nowCnt){
        if(answer==-1){
            return ;
        }

        answer=Math.max(answer,nowCnt);

        for(int i=0;i<4;i++){
            int nextY=nowY+(map[nowY][nowX]*dy[i]);
            int nextX=nowX+(map[nowY][nowX]*dx[i]);
            long nextCnt=nowCnt+1;
            if(nextY>=0 && nextY<N && nextX>=0 && nextX<M) {
                if (ch[nextY][nextX] < nextCnt && map[nextY][nextX] != -1 && visited[nextY][nextX]==0) {
                    ch[nextY][nextX] = nextCnt;
                    visited[nextY][nextX]=1;
                    dfs(nextY, nextX, nextCnt);
                    visited[nextY][nextX]=0;
                }
                else if(visited[nextY][nextX]==1){
                    answer=-1;
                    return ;
                }
            }
        }

    }
}
/*
6 7
12HHHHH
2214HHH
H1HHHHH
H4H9H2H
HHHHHHH
HHH2HHH
->7

5 5
4HHH9
HHHHH
HHH12
HHHHH
3HH2H
->6

3 7
3942178
1234567
9123432
->6

4 4
3HH2
H1HH
H2H1
2219
->8

1 2
11
->-1

3 4
3552
5555
2553
* */