import java.util.*;
import java.io.*;

/*
*당신은 상범 빌딩에 갇히고 말았다. 여기서 탈출하는 가장 빠른 길은 무엇일까?
* 상범 빌딩은 각 변의 길이가 1인 정육면체(단위 정육면체)로 이루어져있다.
* 각 정육면체는 금으로 이루어져 있어 지나갈 수 없거나, 비어있어서 지나갈 수 있게 되어있다.
* 당신은 각 칸에서 인접한 6개의 칸(동,서,남,북,상,하)으로 1분의 시간을 들여
* 이동할 수 있다. 즉, 대각선으로 이동하는 것은 불가능하다. 그리고 상범 빌딩의
* 바깥면도 모두 금으로 막혀있어 출구를 통해서만 탈출할 수 있다.

당신은 상범 빌딩을 탈출할 수 있을까? 만약 그렇다면 얼마나 걸릴까?

입력
입력은 여러 개의 테스트 케이스로 이루어지며, 각 테스트 케이스는
* 세 개의 정수 L, R, C로 시작한다. L(1 ≤ L ≤ 30)은 상범 빌딩의 층 수이다.
* R(1 ≤ R ≤ 30)과 C(1 ≤ C ≤ 30)는 상범 빌딩의 한 층의 행과 열의 개수를 나타낸다.

그 다음 각 줄이 C개의 문자로 이루어진 R개의 행이 L번 주어진다.
* 각 문자는 상범 빌딩의 한 칸을 나타낸다. 금으로 막혀있어 지나갈 수 없는 칸은 '#'으로
* 표현되고, 비어있는 칸은 '.'으로 표현된다. 당신의 시작 지점은 'S'로 표현되고,
* 탈출할 수 있는 출구는 'E'로 표현된다. 각 층 사이에는 빈 줄이 있으며,
* 입력의 끝은 L, R, C가 모두 0으로 표현된다. 시작 지점과 출구는 항상 하나만 있다.

출력
각 빌딩에 대해 한 줄씩 답을 출력한다. 만약 당신이 탈출할 수 있다면 다음과 같이 출력한다.

Escaped in x minute(s).
여기서 x는 상범 빌딩을 탈출하는 데에 필요한 최단 시간이다.

만일 탈출이 불가능하다면, 다음과 같이 출력한다.

Trapped!
*
*
*
3 4 5
S....
.###.
.##..
###.#

#####
#####
##.##
##...

#####
#####
#.###
####E

1 3 3
S##
#E#
###

0 0 0
->
Escaped in 11 minute(s).
Trapped!
*
*
*
* */
public class Main {
    static int L,R,C; //층 행 열
    static char[][][] map;
    static int[][][] ch;
    static int[] dl={1,-1,0,0,0,0};
    static int[] dr={0,0,1,-1,0,0};
    static int[] dc={0,0,0,0,1,-1};
    static int startL,startR,startC,endL,endR,endC;
    static class Position{
        int l;
        int r;
        int c;
        int d;
        public Position(int l,int r,int c,int d){
            this.l=l;
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    static int dist;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder answer=new StringBuilder();
        while(true){
            dist=Integer.MAX_VALUE;
            st=new StringTokenizer(bf.readLine());
            L=Integer.parseInt(st.nextToken());
            R=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            if(L==0 && R==0 && C==0){
                break;
            }
            map=new char[L][R][C];
            for(int i=0;i<L;i++){
                for(int j=0;j<R;j++){
                    String in=bf.readLine();
                    for(int k=0;k<C;k++){
                        map[i][j][k]=in.charAt(k);
                        if(map[i][j][k]=='S'){
                            startL=i;
                            startR=j;
                            startC=k;
                        }
                        else if(map[i][j][k]=='E'){
                            endL=i;
                            endR=j;
                            endC=k;
                        }
                    }
                }
                bf.readLine();
            }

            bfs();
            /*
            * Escaped in 11 minute(s).
Trapped!
            * */
            if(dist==Integer.MAX_VALUE){
                answer.append("Trapped!\n");
            }
            else{
                answer.append("Escaped in "+dist+" minute(s).\n");
            }

        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
    public static void bfs(){
        ch=new int[L][R][C];
        ch[startL][startR][startC]=1;
        ArrayDeque<Position> q=new ArrayDeque<>();
        q.add(new Position(startL,startR,startC,0));
        while(!q.isEmpty()){
            Position now=q.poll();
            int nowL=now.l;
            int nowR=now.r;
            int nowC=now.c;
            int nowD=now.d;
            if(map[nowL][nowR][nowC]=='E'){
                dist=nowD;
            }
            for(int i=0;i<6;i++){
                int nextL=nowL+dl[i];
                int nextR=nowR+dr[i];
                int nextC=nowC+dc[i];
                int nextD=nowD+1;
                if(isIn(nextL,nextR,nextC)){
                    ch[nextL][nextR][nextC]=1;
                    q.add(new Position(nextL,nextR,nextC,nextD));
                }

            }
        }

    }
    public static boolean isIn(int l,int r,int c){
        if(l>=0 && l<L && r>=0 &&r<R && c>=0 && c<C && map[l][r][c]!='#' && ch[l][r][c]==0){
            return true;
        }
        return false;
    }





}
