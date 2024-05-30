import java.io.*;
import java.util.*;
public class Main {
    static char[][] map=new char[12][6];
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static class Node{
        int y;
        int x;
        char c;
        int cnt;
        public Node(int y,int x,char c,int cnt){
            this.y=y;
            this.x=x;
            this.c=c;
            this.cnt=cnt;
        }
    }
    static int ans;
    static int flag;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<12;i++){
            String str=bf.readLine();
            for(int j=0;j<6;j++){
                map[i][j]=str.charAt(j);
            }
        }
        while(flag==0) {
            flag=1;
            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.') {
                        bfs(i, j);
                    }
                }
            }
            if(flag==0){
                ans++;
            }
            for(int a=10;a>=0;a--){
                for(int b=0;b<6;b++){
                    if(map[a][b]!='.' && map[a+1][b]=='.'){
                        down(a,b,map[a][b]);
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static void bfs(int y,int x){
        ArrayDeque<Node> q=new ArrayDeque<>();
        ArrayDeque<Position> tmp=new ArrayDeque<>();
        q.add(new Node(y,x,map[y][x],1));
        char nowC=map[y][x];
        map[y][x]='.';
        int nowCnt=1;
        while(!q.isEmpty()){
            Node now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            nowC=now.c;
            tmp.add(new Position(nowY,nowX));
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(nextY>=0 && nextY<12 && nextX>=0 && nextX<6 && map[nextY][nextX]==nowC){
                    map[nextY][nextX]='.';
                    nowCnt++;
                    q.add(new Node(nextY,nextX,nowC,nowCnt+1));
                }
            }
        }
        if(nowCnt<4){
            while(!tmp.isEmpty()){
                Position now=tmp.poll();
                int nowY=now.y;
                int nowX=now.x;
                map[nowY][nowX]=nowC;
            }
        }
        else{
//            for(int i=10;i>=0;i--){
//                for(int j=0;j<6;j++){
//                    if(map[i][j]!='.' && map[i+1][j]=='.'){
//                        down(i,j,map[i][j]);
//                    }
//                }
//            }
            flag=0;
//            for(int i=0;i<12;i++){
//                for(int j=0;j<6;j++){
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("-------------");
        }
    }
    public static void down(int y,int x,char c){
        int j=y+1;
        while(j<=11 && map[j][x]=='.'){
            j++;
        }
        map[y][x]='.';
        map[j-1][x]=c;

    }
}
/*
......
......
......
......
......
GG....
RR....
YR....
RR....
YRY...
RRRYGG
GYGRYY
->1

......
......
......
......
.G....
GY....
RR....
YR....
RR....
YRY...
RRRYGG
GYGRYY
->3
* */