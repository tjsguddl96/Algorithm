import java.io.*;
import java.util.*;

public class Main {
    static int H,W,N,M; //h : 행, w : 열, n: 세로, m: 가로
    static int[] dy={1,0};
    static int[] dx={0,1};
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
        H=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int Y=0;
        int y=1;
        while(y<H+1){
            Y++;
            y+=(N+1);
        }
        int X=0;
        int x=1;
        while(x<W+1){
            X++;
            x+=(M+1);
        }
        System.out.println(X*Y);
    }

}