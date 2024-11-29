import java.util.*;
import java.io.*;
public class Main {
    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};
    static int N,M;
    static int initY,initX,initD;
    static int[][] map;
    static class Node{
        int y;
        int x;
        int d;
        public Node(int y,int x,int d){
            this.y=y;
            this.x=x;
            this.d=d;
        }
    }
    static ArrayDeque<Node> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        st=new StringTokenizer(bf.readLine());
        initY=Integer.parseInt(st.nextToken());
        initX=Integer.parseInt(st.nextToken());
        initD=Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        q.add(new Node(initY,initX,initD));
        int answer=1;
        map[initY][initX]=2; //2이면 청소 완
        boolean working=true;
        while(working && !q.isEmpty()){
            Node now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowD=now.d;
//            System.out.println(nowY+" "+nowX+" "+nowD);
            boolean flag=false;
//            answer++;
            for(int i=1;i<5;i++){
                int nextD=(nowD-i+4)%4;
                int nextY=nowY+dy[nextD];
                int nextX=nowX+dx[nextD];
                if(nextY>=0 && nextY<N && nextX>=0 && nextX<M && map[nextY][nextX]==0){
                    answer++;
                    q.add(new Node(nextY,nextX,nextD));
                    map[nextY][nextX]=2;
                    flag=true;
                    break;
                }
            }
            if(!flag){ //4칸 모두 청소되지 않은 빈 칸이 없는 경우
                int backD=(nowD+2)%4;
                int nextY=nowY+dy[backD];
                int nextX=nowX+dx[backD];
                if(nextY>=0 && nextY<N && nextX>=0&& nextX<M && map[nextY][nextX]!=1){
                    q.add(new Node(nextY,nextX,nowD));
                }
                else{
                    working=false;
                }
            }

        }
        System.out.println(answer);


    }
}