import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static char[][] map;
    static int[] dx={-1,1,0,0}; //왼,오,위,아래
    static int[] dy={0,0,-1,1};
    static HashMap<Integer,Integer> area=new HashMap<>();
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken()); //세로
        M=Integer.parseInt(st.nextToken()); //가로
        for(int i=0;i<16;i++){
            area.put(i,i*4+1);
        }
        map=new char[N][M];
        for(int i=0;i<N;i++){
            String str=bf.readLine();
            for(int j=0;j<str.length();j++){
                char c=str.charAt(j);
                map[i][j]=c;
            }
        }
        char[][] map2=new char[N][M];
        answer=1;
        for(int centerY=0;centerY<N;centerY++){
            for(int centerX=0;centerX<M;centerX++){
                if(map[centerY][centerX]=='#'){
                    //map -> map2 copy
                    for(int i=0;i<N;i++){
                        for(int j=0;j<M;j++){
                            map2[i][j]=map[i][j];
                        }
                    }
                    makeCross(map2,centerY,centerX);

                }

            }

        }
        System.out.println(answer);
    }
    public static int crossLength(char[][] map,int y,int x){
        int cnt=1;
        while(true){ //왼,오,위,아래 순
            int leftY=y+(dy[0]*cnt);
            int leftX=x+(dx[0]*cnt);
            int rightY=y+(dy[1]*cnt);
            int rightX=x+(dx[1]*cnt);
            int upY=y+(dy[2]*cnt);
            int upX=x+(dx[2]*cnt);
            int downY=y+(dy[3]*cnt);
            int downX=x+(dx[3]*cnt);
            if(isIn(map,leftY,leftX) && isIn(map,rightY,rightX) &&isIn(map,upY,upX) &&isIn(map,downY,downX)){
                cnt++;
            }else{
                break;
            }
        }
        return cnt-1;
    }
    public static int makeCross(char[][] map,int y,int x){
        int cnt=1;
        map[y][x]='*';
        while(true){ //왼,오,위,아래 순
            int leftY=y+(dy[0]*cnt);
            int leftX=x+(dx[0]*cnt);
            int rightY=y+(dy[1]*cnt);
            int rightX=x+(dx[1]*cnt);
            int upY=y+(dy[2]*cnt);
            int upX=x+(dx[2]*cnt);
            int downY=y+(dy[3]*cnt);
            int downX=x+(dx[3]*cnt);
            if(isIn(map,leftY,leftX) && isIn(map,rightY,rightX) &&isIn(map,upY,upX) &&isIn(map,downY,downX)){
                map[leftY][leftX]='*';
                map[rightY][rightX]='*';
                map[upY][upX]='*';
                map[downY][downX]='*';

                int second=0;
                for(int secondY=0;secondY<N;secondY++){
                    for(int secondX=0;secondX<M;secondX++){
                        if(map[secondY][secondX]!='#'){
                            continue;
                        }
                        second=crossLength(map,secondY,secondX);
                        answer = Math.max(area.get(second) * area.get(cnt), answer);
                    }
                }
                cnt++;

            }else{
                break;
            }
        }
        return cnt-1;
    }
    public static boolean isIn(char[][] map,int y,int x){
        if(y>=0 && y<N && x>=0 && x<M && map[y][x]=='#'){
            return true;
        }
        return false;
    }
    public static boolean canCross(char[][] map,int y,int x){
        for(int i=0;i<4;i++){
            int nextY=y+dy[i];
            int nextX=x+dx[i];
            if(nextY<0 || nextY>=N || nextX<0 || nextX>=M || map[nextY][nextX]!='#'){
                return false;
            }
        }
        return true;
    }
    public static void print(char[][] map){
        int n=map.length;
        int m=map[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }
}
/*
7 10
##########
....#.....
....#.....
##########
....#.....
....#.....
##########
->13
6 10
##########
###...#...
###...#...
##########
###.#.#...
.##.#.#...
->45

6 11
###########
####...#...
####...#...
###########
####.#.#...
#.##.#.#...
->81


5 6
######
######
######
######
######
->25
6 6
######
######
######
######
######
######
->45

6 8
....#...
...##...
..#####.
...##...
....#...
........
->9

3 3
.#.
###
.#.
->1

3 3
.#.
###
.##
->5

7 7
...#...
...#...
...#...
#######
...####
...#.#.
...#...
->25


5 5
#.#.#
.#.#.
#.#.#
.#.#.
#.#.#
->1

7 7
...#...
...#...
...#...
#######
...#...
...#...
...#...
-> 9

7 9
..#...#..
#.#...#..
..#...#..
#########
..#...#..
..#...#..
..#...#..
->45
* */