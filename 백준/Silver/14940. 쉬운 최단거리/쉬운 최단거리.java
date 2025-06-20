import java.util.*;
import java.io.*;


public class Main{

    static class Node implements Comparable<Node>{
        int y;
        int x;
        int d;
        public Node(int y,int x,int d){
            this.y=y;
            this.x=x;
            this.d=d;
        }
        public int compareTo(Node o){
            return this.d-o.d;
        }
    }
    static int N,M;
    static int[][] map;
    static int[][] ch;
    static int INF=Integer.MAX_VALUE;
    static int startY,startX;
    static int[] dy={0,0,1,-1};
    static int[] dx={1,-1,0,0};
    public static void main(String[] Args)throws IOException{
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
                if(map[i][j]==2){
                    startY=i;
                    startX=j;
                }
                ch[i][j]=INF;
            }
        }
        solve();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int now=ch[i][j];
                if(now==INF){
                    if(map[i][j]==0){
                        now=0;
                    }
                    else {
                        now = -1;
                    }
                }
                System.out.print(now+" ");
            }
            System.out.println();
        }


    }
    public static void solve(){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(startY,startX,0));
        ch[startY][startX]=0;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowD=now.d;
            if(ch[nowY][nowX]<nowD){
                return ;
            }
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(isIn(nextY,nextX) && ch[nextY][nextX]>nowD+1){
                    ch[nextY][nextX]=nowD+1;
                    pq.add(new Node(nextY,nextX,ch[nextY][nextX]));
                }
            }

        }

    }
    public static boolean isIn(int y,int x){
        if(y>=0 && y<N && x>=0 && x<M && map[y][x]==1){
            return true;
        }
        return false;
    }
}