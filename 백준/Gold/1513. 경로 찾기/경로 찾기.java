import java.util.*;
import java.io.*;
public class Main {
    //아래 혹은 오른쪽으로만 이동 가능함
    static int[] dy={1,0};
    static int[] dx={0,1};
    static int N,M,C;
    static int[][][][] dp;
    static int[][] map; //map[][]==오락실 idx 이면 오락실
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        dp=new int[C+1][C+1][N+1][M+1];
        for(int i=0;i<C+1;i++){
            for(int p=0;p<C+1;p++) {
                for (int j = 0; j < N + 1; j++) {
                    for (int k = 0; k < M + 1; k++) {
                        dp[i][p][j][k]=-1;
                    }
                }
            }
        }
        //dp[cnt][이전][y][x]
        map=new int[N+1][M+1];
        for(int i=1;i<C+1;i++){
            st=new StringTokenizer(bf.readLine());
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            map[y][x]=i;
        }
        for(int c=0;c<C+1;c++){
            answer.append((solve(c, 0, 1, 1)%1000007)+" ");
        }
        System.out.println(answer.toString());
    }
    public static int solve(int cnt,int visit,int nowY,int nowX){
        if(nowY>N || nowX>M){
            return 0;
        }
        if(nowY==N && nowX==M){
            if(map[nowY][nowX]>visit && cnt==1){
                return 1;
            }
            else if(map[nowY][nowX]==0 && cnt==0){
                return 1;
            }
            return 0;
        }
        if(dp[cnt][visit][nowY][nowX]!=-1){
            return dp[cnt][visit][nowY][nowX];
        }
        int tmp=0;
        if(map[nowY][nowX]==0){
            tmp=(solve(cnt,visit,nowY+1,nowX)%1000007 + solve(cnt,visit,nowY,nowX+1)%1000007);
        }
        else if(map[nowY][nowX]>visit && cnt-1>=0){
            tmp=(solve(cnt-1,map[nowY][nowX],nowY+1,nowX)%1000007 + solve(cnt-1,map[nowY][nowX],nowY,nowX+1)%1000007);
        }

        dp[cnt][visit][nowY][nowX]=tmp%1000007;
        return dp[cnt][visit][nowY][nowX];
    }


}
/*
4 4 4
4 4
1 1
2 2
3 3
//0 0 0 0 0

4 4 4
2 2
1 1
3 3
3 4
//0 2 4 2 0

4 4 4
1 1
2 2
3 3
3 4
//0 2 6 8 4

1 1 0
output : 1

----------
1 1 1
1 1
output : 0 1

2 2 2
2 2
1 1

3 3 2
3 2
3 3
->0 3 3


3 3 2
3 3
3 2


3 3 2
3 2
1 1
* */