import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][] initMap;
    static int[][] map;
    static int continentNum=1;
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static class Node implements Comparable<Node>{
        int y;
        int x;
        int d;
        public Node(int y,int x,int d){
            this.y=y;
            this.x=x;
            this.d=d;
        }
        @Override
        public int compareTo(Node o){
            return this.d-o.d;
        }
    }
    static int answer=Integer.MAX_VALUE;
    static int[][] dist;
    static int[] dy={-1,1,0,0};
    static int[] dx={0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        initMap=new int[N][N];
        map=new int[N][N];
        dist=new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                initMap[i][j]=Integer.parseInt(st.nextToken());
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(initMap[i][j]==1 && map[i][j]==0){
                    makeContinent(i,j);
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]!=0){
                    boolean flag=false;
                    for(int k=0;k<4;k++){
                        int nextI=i+dy[k];
                        int nextJ=j+dx[k];
                        if(nextI>=0 && nextI<N && nextJ>=0 && nextJ<N && map[nextI][nextJ]==0 && dist[nextI][nextJ]>1){
                            makeBridge(i,j,map[i][j]);
                        }
                    }
                }
            }
        }
        System.out.println(answer);

    }
    public static void makeBridge(int startY,int startX,int startContinent){
        PriorityQueue<Node> q=new PriorityQueue<>();
        q.add(new Node(startY,startX,0));
        dist[startY][startX]=0;
        while(!q.isEmpty()){
            Node now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowD=now.d;
            if(dist[nowY][nowX]<nowD){
                continue;
            }
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                int nextD=nowD+1;
                if(nextY>=0 && nextY<N && nextX>=0 && nextX<N && dist[nextY][nextX]>nextD && map[nextY][nextX]==0){
                    dist[nextY][nextX]=nextD;
                    q.add(new Node(nextY,nextX,nextD));
                }
                else if(nextY>=0 && nextY<N && nextX>=0 && nextX<N && dist[nextY][nextX]>nextD && map[nextY][nextX]!=0 && startContinent!=map[nextY][nextX]){
                    answer=Math.min(answer,nowD);
                }
            }
        }
    }
    public static void makeContinent(int startY,int startX){
        ArrayDeque<Position> q=new ArrayDeque<>();
        q.add(new Position(startY,startX));
        map[startY][startX]=continentNum;
        while(!q.isEmpty()){
            Position now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(nextY>=0 && nextY<N && nextX>=0 && nextX<N && map[nextY][nextX]==0 && initMap[nextY][nextX]==1){
                    q.add(new Position(nextY,nextX));
                    map[nextY][nextX]=continentNum;
                }
            }
        }
        continentNum++;
    }
}
/*
5
1 1 1 0 1
1 1 0 0 1
0 0 0 0 0
0 0 0 0 0
1 1 1 1 1
->1
* */