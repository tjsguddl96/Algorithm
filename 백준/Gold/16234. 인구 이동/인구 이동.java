import java.io.*;
import java.util.*;
public class Main {
    static int N,L,R;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static int[][] a;
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static int[][] ch;
    static ArrayDeque<Position> q;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        a=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                a[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int answer=0;
        while(true){
            ch=new int[N][N];
            int flag=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(ch[i][j]==0){
                        ch[i][j]=1;
                        q=new ArrayDeque<>();
                        ArrayList<Position> union=new ArrayList<>();
//                        System.out.println(i+" "+j);
//                        System.out.println(answer+"!");
                        q.add(new Position(i,j));
                        int unionCnt=1;
                        int unionPeople=a[i][j];
                        union.add(new Position(i,j));
                        while(!q.isEmpty()){
                            Position now=q.poll();
                            for(int k=0;k<4;k++){
                                int nextY=now.y+dy[k];
                                int nextX=now.x+dx[k];
                                if(nextY>=0 && nextY<N && nextX>=0 && nextX<N && ch[nextY][nextX]==0 && Math.abs(a[now.y][now.x]-a[nextY][nextX])>=L && Math.abs(a[now.y][now.x]-a[nextY][nextX])<=R){
//                                    System.out.println(nextY+" "+nextX+"~");
                                    q.add(new Position(nextY,nextX));
                                    ch[nextY][nextX]=1;
                                    unionCnt++;
                                    unionPeople+=a[nextY][nextX];
                                    union.add(new Position(nextY,nextX));
                                }
                            }
                        }
                        int newPeople=unionPeople/unionCnt;
//                        System.out.println(newPeople+"임");
//                        System.out.println(union.size()+"사이즈");
                        if(union.size()>=2){
                            flag=1;
                        }
//                        System.out.println(flag+"flag");
                        for(int k=0;k<union.size();k++){
                            Position u=union.get(k);
                            a[u.y][u.x]=newPeople;
                        }
//                        for(int y=0;y<N;y++){
//                            for(int x=0;x<N;x++){
//                                System.out.print(ch[y][x]+" ");
//                            }
//                            System.out.println();
//                        }
//                        System.out.println("------a--------");
//                        for(int y=0;y<N;y++){
//                            for(int x=0;x<N;x++){
//                                System.out.print(a[y][x]+" ");
//                            }
//                            System.out.println();
//                        }
                    }
                }
            }
            if(flag==0){
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}