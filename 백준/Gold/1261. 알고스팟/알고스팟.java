import java.io.*;
import java.util.*;
public class Main {
    static int M,N; //M : 가로, N : 세로
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static int[][] map;
    static class Node implements Comparable<Node>{
        int y;
        int x;
        int wall;
        public Node(int y,int x,int wall){
            this.y=y;
            this.x=x;
            this.wall=wall;
        }
        @Override
        public int compareTo(Node o){
            return this.wall-o.wall;
        }
    }
    static int[][] ch;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        map=new int[N+1][M+1];
        ch=new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            String str=bf.readLine();
            for(int j=1;j<M+1;j++){
                map[i][j]=str.charAt(j-1)-'0';
            }
        }
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(1,1,0));
        ch[1][1]=1;
        int answer=0;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowW=now.wall;
            if(nowY==N && nowX==M){
                answer=nowW;
                break;
            }
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(nextY>=1 && nextY<N+1 && nextX>=1 && nextX<M+1 && ch[nextY][nextX]==0){
                    pq.add(new Node(nextY, nextX, nowW + map[nextY][nextX]));

                    ch[nextY][nextX]=1;
                }
            }
        }
        System.out.println(answer);
    }
}