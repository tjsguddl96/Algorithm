import java.util.*;
import java.io.*;
public class Main {
    static int N,M; //세로, 가로 순
    static int[] dy={-1,1,0,0};
    static int[] dx={0,0,-1,1};
    static int[][] map;
    static int[] d1={1,1,3}; //ㄴ자
    static int[] d2={1,1,2}; //ㄴ자
    static int[] d3={1,3,1}; //ㄹ자
    static int[] d4={1,2,1}; //ㄹ자
    static int[] d5={2,1,3}; //ㅜ자
    static int answer;
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //1자
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int tmp=0;
                for(int k=j;k<j+4;k++){
                    if(k>=M){
                        tmp=0;
                        break;
                    }
                    tmp+=map[i][k];
                }
                answer=Math.max(answer,tmp);
                tmp=0;
                for(int k=i;k<i+4;k++){
                    if(k>=N){
                        tmp=0;
                        break;
                    }
                    tmp+=map[k][j];
                }
                answer=Math.max(answer,tmp);
            }
        }
        //ㅁ자
        for(int i=0;i<N-1;i++){
            for(int j=0;j<M-1;j++){
                int tmp=0;
                for(int y=i;y<i+2;y++){
                    for(int x=j;x<j+2;x++){
                        tmp+=map[y][x];
                    }
                }
                answer=Math.max(answer,tmp);
            }
        }
        //ㄴ자
        int[] nowD=d1;
        for(int r=0;r<4;r++){
            if(r!=0){
                nowD=rotate(nowD);
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    int tmp=cal(i,j,nowD);
                    answer=Math.max(answer,tmp);
                }
            }
        }
        nowD=d2;
        for(int r=0;r<4;r++){
            if(r!=0){
                nowD=rotate(nowD);
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    int tmp=cal(i,j,nowD);
                    answer=Math.max(tmp,answer);
                }
            }
        }
        //ㄹ자
        nowD=d3;
        for(int r=0;r<2;r++){
            if(r!=0){
                nowD=rotate(nowD);
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    int tmp=cal(i,j,nowD);
                    answer=Math.max(answer,tmp);
                }
            }
        }
        nowD=d4;
        for(int r=0;r<2;r++){
            if(r!=0){
                nowD=rotate(nowD);
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    int tmp=cal(i,j,nowD);
                    answer=Math.max(answer,tmp);
                }
            }
        }
        //ㅓ자
        nowD=d5;
        for(int r=0;r<4;r++){
            if(r!=0){
                nowD=rotate(nowD);
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    int tmp=cal2(i,j,nowD);
                    answer=Math.max(answer,tmp);
                }
            }
        }


        System.out.println(answer);

    }
    public static int cal2(int nowY,int nowX,int[] nowD){
        int tmp=map[nowY][nowX];
        for(int i=0;i<nowD.length;i++){
            int nextY=nowY+dy[nowD[i]];
            int nextX=nowX+dx[nowD[i]];
            if(nextY<0 || nextY>=N || nextX<0 || nextX>=M){
                return 0;
            }
            tmp+=map[nextY][nextX];
        }
        return tmp;
    }
    public static int cal(int nowY,int nowX,int[] nowD){
        int tmp=map[nowY][nowX];
        for(int i=0;i<nowD.length;i++){
            nowY+=dy[nowD[i]];
            nowX+=dx[nowD[i]];
            if(nowY<0 || nowY>=N || nowX<0 || nowX>=M){
                return 0;
            }
            if(nowY>=0 && nowY<N && nowX>=0 && nowX<M){
                tmp+=map[nowY][nowX];
            }
        }
        return tmp;
    }

    public static int[] rotate(int[] nowD){
        int[] nextD=new int[nowD.length];
        for(int i=0;i<nowD.length;i++){
            if(nowD[i]==0){
                nextD[i]=3;
            }
            else if(nowD[i]==1){
                nextD[i]=2;
            }
            else if(nowD[i]==2){
                nextD[i]=0;
            }
            else{
                nextD[i]=1;
            }
        }
        return nextD;
    }
}