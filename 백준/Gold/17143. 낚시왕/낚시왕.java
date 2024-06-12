import java.util.*;
import java.io.*;
public class Main {
    static int R,C,M; //행 열 상어수
    static class Shark{
        int y;
        int x;
        int s;
        int d;
        int z;
        public Shark(int y,int x,int s,int d,int z){
            this.y=y;
            this.x=x;
            this.s=s;
            this.d=d;
            this.z=z;
        }
    }
    static int[][] map;
    static Shark[] sharks;
    static int[] dy={0,-1,1,0,0}; //1=위, 2=아래, 3=오른쪽, 4=왼쪽
    static int[] dx={0,0,0,1,-1};
    static int player=1; //낚시왕의 현재 열 위치
    static int answer;
    static int[] ch;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[R+1][C+1];
        ch=new int[M+1];
        sharks=new Shark[M+1];
        for(int i=1;i<M+1;i++){
            st=new StringTokenizer(bf.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            int z=Integer.parseInt(st.nextToken());
            map[r][c]=i;
            if(d==1 || d==2){ //위 아래
                s=s%((R-1)*2);
            }
            else{
                s=s%((C-1)*2);
            }
            sharks[i]=new Shark(r,c,s,d,z);
        }
        while(player<C+1){
            for(int i=1;i<R+1;i++){
                if(map[i][player]!=0){
                    int sharkNum=map[i][player];
                    answer+=sharks[sharkNum].z;
                    ch[sharkNum]=1;
                    map[i][player]=0;
                    break;
                }
            }
            map=new int[R+1][C+1];
            sharkMove();
            player++;
        }
        System.out.println(answer);
    }
    public static void sharkMove(){
        for(int i=1;i<M+1;i++){
            if(ch[i]==0){ //낚시왕에게 잡히지 않은 상어
               Shark shark=sharks[i];
               int nowY=shark.y;
               int nowX=shark.x;
               int nowS=shark.s;
               int nowD=shark.d;
               int nowZ=shark.z;

                for(int j=0;j<nowS;j++){
                    nowY+=dy[nowD];
                    nowX+=dx[nowD];
                    if(nowY<1){
                        nowD=2;
                        nowY=2;
                    }
                   else if(nowY>R){
                        nowD=1;
                        nowY=R-1;
                    }
                    if(nowX<1){
                        nowD=3;
                       nowX=2;
                   }
                   else if(nowX>C){
                       nowD=4;
                       nowX=C-1;
                   }
               }
               sharks[i].y=nowY;
               sharks[i].x=nowX;
               sharks[i].d=nowD;

               if(map[nowY][nowX]!=0){
                   if(sharks[map[nowY][nowX]].z>nowZ){
                       ch[i]=1;
                   }
                   else{
                       ch[map[nowY][nowX]]=1;
                       map[nowY][nowX]=i;
                   }
               }else{
                   map[nowY][nowX]=i;
               }
            }
        }
    }
}
/*
5 5 4
1 1 7 2 1
4 1 2 1 2
2 2 7 3 3
2 3 2 4 4
* */