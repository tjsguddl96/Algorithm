import java.util.*;
import java.io.*;
public class Main {
    static int W,H; //가로, 세로
    static char[][] map;
    static class Node implements Comparable<Node>{
        int d;
        int y;
        int x;
        int c;
        public Node(int d,int y,int x,int c){
            this.d=d;
            this.y=y;
            this.x=x;
            this.c=c;
        }
        @Override
        public int compareTo(Node o){
            return this.c-o.c;
        }
    }
    static int[][] ch;
    static int[] dy={-1,0,1,0};
    static int[] dx={0,-1,0,1};
    static int startY;
    static int startX;
    static int endY;
    static int endX;
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        W=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        map=new char[H][W];
        ch=new int[H][W];
        boolean flag=true;
        for(int i=0;i<H;i++){
            String input=bf.readLine();
            for(int j=0;j<W;j++){
                map[i][j]=input.charAt(j);
                ch[i][j]=Integer.MAX_VALUE;
                if(flag && map[i][j]=='C'){
                    startY=i;
                    startX=j;
                    flag=false;
                }
                else if(!flag && map[i][j]=='C'){
                    endY=i;
                    endX=j;
                }
            }
        }
        ch[startY][startX]=0;
        pq.add(new Node(-1,startY,startX,0));
        int answer=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowD=now.d;
            int nowY=now.y;
            int nowX=now.x;
            int nowC=now.c;
            if(nowY==endY && nowX==endX){
                answer=Math.min(ch[nowY][nowX],answer);
                break;
            }
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(isIn(nextY,nextX)){
                    if(i!=nowD){//방향 달라졌을때
                        if(ch[nextY][nextX]>nowC+1){
                            ch[nextY][nextX]=nowC+1;
                            pq.add(new Node(i,nextY,nextX,ch[nextY][nextX]));
                        }
                    }
                    else{ //방향 일정
                        if(ch[nextY][nextX]>=nowC){
                            ch[nextY][nextX]=nowC;
                            pq.add(new Node(i,nextY,nextX,ch[nextY][nextX]));
                        }

                    }
                }
            }
        }
//        for(int i=0;i<H;i++){
//            for(int j=0;j<W;j++){
//                if(ch[i][j]==Integer.MAX_VALUE){
//                    ch[i][j]=8;
//                }
//                System.out.print(ch[i][j]+" ");
//            }
//            System.out.println();
//        }
//        for(int i=0;i<H;i++){
//            for(int j=0;j<W;j++){
//                System.out.print(ch2[i][j].toString()+"   ");
//            }
//            System.out.println();
//        }
        System.out.println(answer-1);

    }
    public static boolean isIn(int y,int x){
        if(y>=0 && y<H && x>=0 && x<W && map[y][x]!='*'){
            return true;
        }
        return false;
    }
}
/*
4 4
...C
**..
C...
....
->1

4 4
...C
**..
...C
....
->0

3 4
..C
...
...
C*.
* */