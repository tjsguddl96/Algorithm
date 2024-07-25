import java.util.*;
import java.io.*;
public class Main {
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static int N,M,h,w,K;
    static int[][] map;
    static int[][] ch;
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static Position[] holes;
    static ArrayDeque<Position> q=new ArrayDeque<>();
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        h=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());
        map=new int[N+1][M+1];
        ch=new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<M+1;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        K=Integer.parseInt(bf.readLine());
        holes=new Position[K];
        for(int i=0;i<K;i++){
            st=new StringTokenizer(bf.readLine());
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            holes[i]=new Position(y,x);
            ch[y][x]=1;
            q.add(new Position(y,x));
        }
        while(!q.isEmpty()){
            Position now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(canGo(nextY,nextX,nowY,nowX)){
                    ch[nextY][nextX]=1;
                    q.add(new Position(nextY,nextX));
                }
            }
        }
        map=new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                map[i][j]=map[i][j-1]+map[i-1][j]-map[i-1][j-1]+ch[i][j];
            }
        }
        for(int i=1;i<=N+1-h;i++){
            for(int j=1;j<=M+1-w;j++){
                int tmp=map[i+h-1][j+w-1]-map[i+h-1][j-1]-map[i-1][j+w-1]+map[i-1][j-1];
                if(tmp==(w*h)){
                    answer++;
                }
            }
        }
        System.out.println(answer);





    }
    public static boolean canGo(int nextY,int nextX,int nowY,int nowX){
        if(nextY>=1 && nextY<=N && nextX>=1 && nextX<=M && map[nextY][nextX]>=map[nowY][nowX] && ch[nextY][nextX]==0){
            return true;
        }
        return false;
    }
}