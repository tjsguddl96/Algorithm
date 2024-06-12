import java.util.*;
import java.io.*;
public class Main {
    static int N,M; //세로 가로
    static int answer;
    static int[][] map;
    static int[][] ch; //ch=1이면 갈수가 없는 곳임
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        ch=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                ch[i][j]=-1;
            }
        }
        dfs(0,0);
        System.out.println(ch[0][0]);
    }
    public static int dfs(int nowY,int nowX){
        if(nowY==N-1 && nowX==M-1) {
            return 1;
        }
        if(ch[nowY][nowX]!=-1){
            return ch[nowY][nowX];
        }
        else {
            ch[nowY][nowX]=0;
            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];
                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && map[nextY][nextX] < map[nowY][nowX]) {
                    ch[nowY][nowX]+=dfs(nextY, nextX);
                }
            }
        }
        return ch[nowY][nowX];
    }
}