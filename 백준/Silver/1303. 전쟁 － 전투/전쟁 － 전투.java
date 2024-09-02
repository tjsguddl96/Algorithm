import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static char[][] map;
    static int[][] ch;
    static class Node{
        int y;
        int x;
        public Node(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static int answerW;
    static int answerB;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new char[M][N];
        ch=new int[M][N];
        for(int i=0;i<M;i++){
            String str=bf.readLine();
            for(int j=0;j<N;j++){
                map[i][j]=str.charAt(j);
            }
        }
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(ch[i][j]==0){
                    int cnt=bfs(i,j,map[i][j]);
                    if(map[i][j]=='W') {
                        answerW += Math.pow(cnt, 2);
                    }
                    else{
                        answerB+=Math.pow(cnt,2);
                    }
                }
            }
        }
        System.out.println(answerW+" "+answerB);
    }
    public static int bfs(int nowYY,int nowXX,char nowChar){
        ArrayDeque<Node> q=new ArrayDeque<>();
        q.add(new Node(nowYY,nowXX));
        int cnt=0;
        ch[nowYY][nowXX]=1;
        while(!q.isEmpty()){
            Node now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            cnt++;
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(isIn(nextY,nextX) && map[nextY][nextX]==nowChar && ch[nextY][nextX]==0){
                    ch[nextY][nextX]=1;
                    q.add(new Node(nextY,nextX));
                }
            }
        }
        return cnt;
    }
    public static boolean isIn(int y,int x){
        if(y>=0 && y<M && x>=0 && x<N){
            return true;
        }
        return false;
    }
}