import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static char[][] map=new char[12][6];
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static ArrayDeque<Node> q=new ArrayDeque<>();
    static PriorityQueue<Node> q2=new PriorityQueue<>();
    static int[][] ch=new int[12][6];
    static class Node implements Comparable<Node>{
        int y;
        int x;
        char color;
        public Node(int y,int x,char color){
            this.y=y;
            this.x=x;
            this.color=color;
        }
        @Override
        public int compareTo(Node o){
            int com=this.y-o.y;
            return com;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<12;i++){
            String str=br.readLine();
            for(int j=0;j<6;j++){
                map[i][j]=str.charAt(j);
            }
        }
        int answer=0;
        int flag=0;
        while(true) {
            flag = 0;
            ch=new int[12][6];
            for (int y = 0; y <12; y++) {
                for (int x = 0; x < 6; x++) {
                    if (map[y][x] != '.' && ch[y][x]==0) {
                        q.add(new Node(y, x, map[y][x]));
                        int cnt = bfs();
                        if (cnt >= 4) {
                            flag = 1;
                            pop();
                        } else {
                            q2 = new PriorityQueue<>();
                        }
                    }
                }
            }
            if(flag==1){
                answer++;
            }
            else if(flag==0){
                break;
            }
        }
//        int y=11;
//        int x=0;
//        while(y>=0){
//            while(x<6){
//                if(map[y][x]!='.'){
//                    q.add(new Node(y,x,map[y][x]));
//                    int cnt=bfs();
//                    if(cnt>=4){ //터뜨리고, 위에 있는 애들 밑으로 와야해
//                        pop();
//                        y=11;
//                        x=0;
//                        answer++;
//                    }
//                    else{
//                        q2=new PriorityQueue<>();
//                        x++;
//                    }
//                }
//                else{
//                    x++;
//                }
//            }
//            y--;
//            x = 0;
//
//        }

        System.out.println(answer);


    }
    public static void pop(){
        while(!q2.isEmpty()){
            Node now=q2.poll();
            int nowY=now.y;
            int nowX=now.x;
            if(nowY>0) {
                for (int i = nowY - 1; i >= 0; i--) {
                    map[i+1][nowX]=map[i][nowX];
                }
            }
            map[0][nowX]='.';
        }

    }
    public static int bfs(){
        int cnt=0;
        while(!q.isEmpty()){
            Node now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            char nowColor=now.color;
            ch[nowY][nowX]=1;
            cnt++;
            q2.add(new Node(nowY,nowX,nowColor));
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(nextY>=0 && nextY<12 && nextX>=0 && nextX<6 && ch[nextY][nextX]==0 && nowColor==map[nextY][nextX]){
                    q.add(new Node(nextY,nextX,map[nextY][nextX]));
                    ch[nextY][nextX]=1;
                }
            }
        }
        return cnt;
    }
}


/*
......
......
......
......
......
......
....G.
....G.
...RR.
..GYR.
RRRRR.
RRYGGG
->2


......
......
......
......
......
......
......
......
......
......
......
RBRBRB
->
*/