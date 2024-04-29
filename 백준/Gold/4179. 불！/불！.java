import java.io.*;
import java.util.*;

public class Main {
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static int R,C;
    static int[][] ch;
    static String[][] map;
    static class Node implements Comparable<Node>{
        int y;
        int x;
        int fire; //fire=1이면 불, fire=0이면 지훈
        int w;
        public Node(int y,int x,int fire,int w){
            this.y=y;
            this.x=x;
            this.fire=fire;
            this.w=w;
        }
        @Override
        public int compareTo(Node o){
            int x=this.w-o.w;
            if(x==0){
                x=o.fire-this.fire;
            }
            return x;
        }
    }
    static int answer=Integer.MAX_VALUE;
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        ch=new int[R][C];
        map=new String[R][C];
        for(int i=0;i<R;i++){
            String input=bf.readLine();
            for(int j=0;j<C;j++){
                map[i][j]=input.charAt(j)+"";
                if(map[i][j].equals("J")){
                    pq.add(new Node(i,j,0,0));
                }
                else if(map[i][j].equals("F")){
                    pq.add(new Node(i,j,1,0));
                }
            }
        }
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowT=now.fire;
            int nowW=now.w;
//            System.out.println(nowY+" "+nowX+" "+nowT+" "+nowW);
            if(nowT==1){//불일때
                for(int i=0;i<4;i++){
                    int nextY=nowY+dy[i];
                    int nextX=nowX+dx[i];
                    if(nextY>=0 && nextY<R && nextX>=0 && nextX<C && !map[nextY][nextX].equals("F") && !map[nextY][nextX].equals("#")){
                        pq.add(new Node(nextY,nextX,1,nowW+1));
                        map[nextY][nextX]="F";
                    }
                }
            }
            else{ //지훈이
                if(nowY==0 || nowY==R-1 || nowX==0 || nowX==C-1){
                    answer=Math.min(answer,nowW+1);
                }
                for(int i=0;i<4;i++){
                    int nextY=nowY+dy[i];
                    int nextX=nowX+dx[i];
                    if(nextY>=0 && nextY<R && nextX>=0 && nextX<C && map[nextY][nextX].equals(".")){
                        pq.add(new Node(nextY,nextX,0,nowW+1));
                        String nextW=(nowW+1)+"";
                        map[nextY][nextX]=nextW;
                    }
                }
            }
//            for(int i=0;i<R;i++){
//                for(int j=0;j<C;j++){
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("--------");
        }

        if(answer==Integer.MAX_VALUE){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(answer);
        }


    }
}
/*
4 4
####
#JF#
#.F#
#..#
* */