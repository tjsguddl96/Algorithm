import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int[][] map;
    static int[][] ch;
    static int[] dy={0,0,1,-1};
    static int[] dx={1,-1,0,0};
    static class Node{
        int y;
        int x;
        public Node(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static int cnt;
    static int max;
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
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(ch[i][j]==0 && map[i][j]==1){
                    cnt++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(cnt+"\n"+max);

    }
    public static void bfs(int startY,int startX){
        ArrayDeque<Node> q=new ArrayDeque<>();
        q.add(new Node(startY,startX));
        ch[startY][startX]=1;
        int cnt=0;
        while(!q.isEmpty()){
            Node now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            cnt++;
            max=Math.max(max,cnt);
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(isIn(nextY,nextX)){
                    ch[nextY][nextX]=1;
                    q.add(new Node(nextY,nextX));
                }
            }
        }
    }
    public static boolean isIn(int y,int x){
        if(y>=0 && y<N && x>=0 && x<M && ch[y][x]==0 && map[y][x]==1){
            return true;
        }
        return false;
    }
}

/*




->



*/
