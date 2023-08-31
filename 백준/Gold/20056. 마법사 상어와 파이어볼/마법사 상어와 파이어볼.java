import java.io.*;
import java.util.*;
public class Main {
    public static int[] dy={-1,-1,0,1,1,1,0,-1};
    public static int[] dx={0,1,1,1,0,-1,-1,-1};
    public static int N,M,K;
    public static class Fire{
        int y;
        int x;
        int m;
        int s;
        int d;
        public Fire(int y, int x,int m,int s,int d){
            this.y=y-1;
            this.x=x-1;
            this.m=m;
            this.s=s;
            this.d=d;
        }
    }
    public static ArrayDeque<Fire> q=new ArrayDeque<>();
    public static ArrayList<Fire>[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        map=new ArrayList[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j]=new ArrayList<>();
            }
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            q.offer(new Fire(y,x,m,s,d));
        }
        for(int k=0;k<K;k++){
            move();
            split();
        }
        int answer=0;
        while(!q.isEmpty()){
            Fire now=q.poll();
            answer+=now.m;
        }
        System.out.println(answer);
    }
    public static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int z=0;z<map[i][j].size();z++){
                    System.out.print(map[i][j].get(z).m+", ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }
    public static void move(){
        while(!q.isEmpty()){
            Fire now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowM=now.m;
            int nowS=now.s;
            int nowD=now.d;
            int nextY=nowY+(dy[nowD]*nowS);
            if(nextY>=0){
                nextY=nextY%N;
            }else{
                nextY=(N+nextY%N)%N;
            }
            int nextX=nowX+(dx[nowD]*nowS);
            if(nextX>=0){
                nextX=nextX%N;
            }else{
                nextX=(N+nextX%N)%N;
            }
            map[nextY][nextX].add(new Fire(nextY,nextX,nowM,nowS,nowD));

        }
    }
    public static void split(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int sumM=0;
                int sumS=0;
                int sumD=0;
                if(map[i][j].size()>1) {
                    int size=map[i][j].size();
                    int prev=(map[i][j].get(0).d)%2;
                    int flag=0; //flag=0 이면 모두 d가 홀 아니면 짝인 경우

                    while(!map[i][j].isEmpty()){
                        Fire now=map[i][j].remove(0);
                        sumM+=now.m;
                        sumS+=now.s;
                        if(prev!=((now.d)%2) && flag==0){
                            flag=1;
                        }
                    }
                    sumM/=5;
                    sumS/=size;
                    if(sumM>0) {
                        for (int z = 0; z < 4; z++) {
                            if (flag == 0) {
                                q.offer(new Fire(i, j, sumM, sumS, z * 2));
                            } else {
                                q.offer(new Fire(i, j, sumM, sumS, z * 2 + 1));
                            }
                        }
                    }
                }else if(map[i][j].size()==1){ //map에 그냥 fire가 1개일때,
                    Fire now=map[i][j].remove(0);
                    q.offer(now);
                }

            }
        }
    }
}
