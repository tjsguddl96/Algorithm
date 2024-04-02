import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int ch[][];
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static class Position implements Comparable<Position>{
        int y;
        int x;
        int d;
        public Position(int y,int x,int d){
            this.y=y;
            this.x=x;
            this.d=d;
        }
        @Override
        public int compareTo(Position o){
            return this.d-o.d;
        }
    }
    static Position start;
    static ArrayList<Position> keys=new ArrayList<>();
    static PriorityQueue<Position> pq=new PriorityQueue<>();
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N+1][N+1];
        ch=new int[N+1][N+1];
        parent=new int[M+1];
        for(int i=0;i<M+1;i++){
            parent[i]=i;
        }
        keys.add(new Position(0,0,0));
        int keyCnt=1;
        for(int i=1;i<N+1;i++){
            String input=bf.readLine();
            for(int j=1;j<N+1;j++){
                char m=input.charAt(j-1);
                if(m=='1'){ //벽 -> -1
                    map[i][j]=-1;
                }
                else if(m=='0'){ //길 -> 0
                    map[i][j]=0;
                }
                else if(m=='S'){ //시작 -> -2
                    map[i][j]=-2;
                    start=new Position(i,j,0);
                }
                else if(m=='K'){
                    map[i][j]=keyCnt;
                    keyCnt++;
                    keys.add(new Position(i,j,0));
                }
            }
        }
        BFS(start,0);
        for(int i=1;i<M+1;i++){
            BFS(keys.get(i),i);
        }
        int answer=0;
        while(!pq.isEmpty()){
            Position now=pq.poll();
            int a=now.y;
            int b=now.x;
            int d=now.d;
            if(findParent(a)!=findParent(b)){
                union(a,b);
                answer+=d;
            }
        }
        for(int i=0;i<M+1;i++){
            if(findParent(parent[i])!=0){
                answer=-1;
                break;
            }
        }
        System.out.println(answer);
    }
    public static int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return findParent(parent[x]);
    }
    public static void union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);
        if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }
    public static void BFS(Position st,int idx){ //idx==0 이면 st=S임, idx>=1 이면, st=Key
        ArrayDeque<Position> q=new ArrayDeque<>();
        ch=new int[N+1][N+1];
        q.add(st);
        ch[st.y][st.x]=1;
        while(!q.isEmpty()){
            Position now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowD=now.d;
            if(map[nowY][nowX]>0 || map[nowY][nowX]==-2){ //key -> dist[][]에 저장
                if(map[nowY][nowX]==-2){
                    pq.add(new Position(idx,0,nowD));
                }else {
                    pq.add(new Position(idx,map[nowY][nowX],nowD));
                }
            }
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                int nextD=nowD+1;
                if(nextY>=1 && nextY<N+1 && nextX>=1 && nextX<N+1 && ch[nextY][nextX]==0 && map[nextY][nextX]!=-1){
                    q.add(new Position(nextY,nextX,nextD));
                    ch[nextY][nextX]=1;
                }
            }

        }
    }
}
/*
6 4
111111
10K011
000001
K0S0K1
000011
10K011

6 4
111111
10K011
000001
K0S0K1
K00011
100011
->7

* */