import java.util.*;
import java.io.*;

public class Main {
    static int N,M,K; //세로, 가로, 스티커 갯수
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][] map;
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static int[][] tmp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        K=Integer.parseInt(st.nextToken());
        int answer=0;
        for(int s=0;s<K;s++){
            st=new StringTokenizer(bf.readLine());
            int R=0; //행
            int C=0; //열
            R=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            int[][] sticker=new int[R][C];
            for(int r=0;r<R;r++){
                st=new StringTokenizer(bf.readLine());
                for(int c=0;c<C;c++){
                    sticker[r][c]=Integer.parseInt(st.nextToken());
                }
            }
            tmp=new int[N][M]; //임시 테이블
            int flag=0;
            for(int rotate=0;rotate<4;rotate++){
                flag=0;
                if(rotate!=0){
                    sticker=rotate(sticker);
                    R=sticker.length;
                    C=sticker[0].length;
                }
                for(int startY=0;startY<N;startY++){ //모든 맵 y,x 순회
                    for(int startX=0;startX<M;startX++){
                        flag=0;
                        //map -> tmp copy
                        for(int y=0;y<N;y++){
                            for(int x=0;x<M;x++){
                                tmp[y][x]=map[y][x];
                            }
                        } //map -> tmp copy 끝

                        //현재 스티커 순회
                        for(int sY=0;sY<R;sY++){
                            for(int sX=0;sX<C;sX++){
                                //범위를 벗어나면 스티커 순회를 빠져나오고, map도 원상태
                                if(startY+sY>=N || startX+sX>=M){
                                    flag=1;
                                    break;
                                }
                                if(tmp[startY+sY][startX+sX]==1 && sticker[sY][sX]==1){ //이미 tmp(map)에 1고, 스티커도 붙여야 되는 곳이면 스티커 순회를 빠져나와
                                    flag=1;
                                    break;
                                }
                                tmp[startY+sY][startX+sX]+=sticker[sY][sX];
                            }
                            if(flag==1){ //범위를 벗어나는 경우 현재 스티커 순회를 빠져나와
                                break;
                            }
                        }//현재 스티커 순회 끝
                        if(flag==0){
                            for(int y=0;y<N;y++){
                                for(int x=0;x<M;x++){
                                    map[y][x]=tmp[y][x];
                                }
                            }
                            break;
                        }
                    }
                    if(flag==0){
                        break;
                    }
                }//모든 맵 y,x 순회 끝
                if(flag==0){
                    //tmp -> map copy

                    break;
                }

            }




//            for(int startY=0; startY<N; startY++){
//                int flag=0;
//                for(int startX=0;startX<M;startX++){
//                    int[][] sticker=new int[oR][oC];
//                    for(int sy=0;sy<oR;sy++){
//                        for(int sx=0;sx<oC;sx++){
//                            sticker[sy][sx]=sticker1[sy][sx];
//                        }
//                    }
//                    for(int rotate=0;rotate<4;rotate++){
//                        if(flag==2){
//                            break;
//                        }
//                        int R=oR;
//                        int C=oC;
//                        if(rotate!=0){ //rotate==0이면, rotate 안해
//                            sticker=rotate(sticker);
//                            R=sticker.length;
//                            C=sticker[0].length;
//                        }
//
//                        flag=0;
//                        //map -> tmp copy
//                        for(int y=0;y<N;y++){
//                            for(int x=0;x<M;x++){
//                                tmp[y][x]=map[y][x];
//                            }
//                        }
//                        //map -> tmp copy 끝
//
//                        //계산 시작
//                        for(int stickerY=0;stickerY<R;stickerY++){
//                            for(int stickerX=0;stickerX<C;stickerX++){
//                                if(startY+stickerY>=N || startX+stickerX>=M){
//                                    flag=1;
//                                    break;
//                                }
//                                if(tmp[startY+stickerY][startX+stickerX]==1 && sticker[stickerY][stickerX]==1){
//                                    //원래 map으로 돌아가
//                                   flag=1;
//                                   break;
//                                }
//                                tmp[startY+stickerY][startX+stickerX]+=sticker[stickerY][stickerX];
//                            }
//                            //원래 map으로 돌아가는 경우 flag=1인 경우
//                            if(flag==1){
//                                break;
//                            }
//                            flag=2;
//                        }
//                        if(flag==2){
//                            break;
//                        }
//                    }
//                    if(flag==2) {
//                        //tmp->map copy
//                        for (int y = 0; y < N; y++) {
//                            for (int x = 0; x < M; x++) {
//                                map[y][x] = tmp[y][x];
//                            }
//                        }
//                        break;
//                    }
//
//                }
//                if(flag==2){
//                    break;
//                }
//            }
        }
//        print(map);
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
    public static int[][] rotate(int[][] map){
        int n=map.length;
        int m=map[0].length;
        int[][] tmp=new int[m][n];
        for(int y=0;y<n;y++){
            for(int x=0;x<m;x++){
                int tmpY=x;
                int tmpX=(n-1)-y;
                tmp[tmpY][tmpX]=map[y][x];
            }
        }
        return tmp;
    }
    public static void print(int[][] map){
        int n=map.length;
        int m=map[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }
}