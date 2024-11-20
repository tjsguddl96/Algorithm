import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][] map;
    static int[] dy={0,1};
    static int[] dx={1,0};
    static int[][][] dp;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        map=new int[N][N];
        dp=new int[N][N][3];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solve(0,0,0));
    }
    //dp[y][x][0]=해당 위치에서 딸기 우유를 먹을때 최대 갯수
    //dp[y][x][1]=해당 위치에서 초코 우유를 먹을때 최대 갯수
    //dp[y][x][2]=해당 위치에서 바나나 우유를 먹을때 최대 갯수
    public static int solve(int nowY,int nowX,int mustEat){
        if(nowY==N-1 && nowX==N-1){
            if(mustEat==map[nowY][nowX]){
                dp[nowY][nowX][mustEat]=1;
            }
            else{
                dp[nowY][nowX][mustEat]=0;
            }
            return dp[nowY][nowX][mustEat];
        }

        if(dp[nowY][nowX][mustEat]!=-1){
            return dp[nowY][nowX][mustEat];
        }

        int max=0;
        int nextEat=(mustEat+1)%3;
        for(int i=0;i<2;i++){
            int nextY=nowY+dy[i];
            int nextX=nowX+dx[i];
            if(nextY>=0 && nextY<N && nextX>=0 && nextX<N){
                if(mustEat==map[nowY][nowX]) { //먹을 수 있음 이전과 지금 패턴이 규칙을 따름
                    max = Math.max(max, 1+solve(nextY, nextX, nextEat));
                }
                max=Math.max(max,solve(nextY,nextX,mustEat));
            }
        }
        dp[nowY][nowX][mustEat]=max;
        return dp[nowY][nowX][mustEat];
    }
}

/*
4
0 0 0 0
0 1 2 0
1 2 0 2
0 0 1 0
->5

4
1 0 0 0
0 1 2 0
1 2 0 2
0 0 1 0
->5

3
2 2 1
2 1 1
1 1 0
->1


2
1 1
1 1
->0

4
2 2 1 2
1 2 1 2
1 2 1 2
0 1 2 0
->4

3
0 1 2
0 1 2
0 1 2
->3

1
1

* */