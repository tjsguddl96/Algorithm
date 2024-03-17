import java.util.*;
import java.io.*;

public class Main {
    static int M,N,L; //사대 수, 동물 수, 사정거리
    static int[] m;
    static Position[] n;
    static class Position{
        int x;
        int y;
        public Position(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        m=new int[M];
        n=new Position[N];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<M;i++){
            m[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(m);
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int left=0;
            int right=M-1;
            int mid=0;
            while(left<=right){
                mid=(left+right)/2;
                if(isIn(new Position(x,y),m[mid])>L && x>=m[mid]){ //왼쪽으로
                    left=mid+1;
                }
                else if(isIn(new Position(x,y),m[mid])>L && x<=m[mid]){
                    right=mid-1;
                }
                else{
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);

    }
    public static int isIn(Position position,int x){
        return Math.abs(x-position.x)+position.y;
    }
}