import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static boolean[] isOpen; //isOpen[i]=true -> i는 열려있다.
    static int[] gate;
    static long answer=Long.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        isOpen=new boolean[N+1];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        isOpen[Integer.parseInt(st.nextToken())]=true;
        isOpen[Integer.parseInt(st.nextToken())]=true;
        M=Integer.parseInt(bf.readLine());
        gate=new int[M];
        for(int i=0;i<M;i++){
            gate[i]=Integer.parseInt(bf.readLine());
        }
        solve(0,0,0);
        solve(0,0,1);
        System.out.println(answer);
    }
    //dir==0 -> 왼, dir==1 -> 오
    public static void solve(int idx,long cnt,int dir){
        if(idx==M){
            answer=Math.min(answer,cnt);
            return ;
        }
        if(dir==0 && gate[idx]==1){
            return ;
        }
        else if(dir==1 && gate[idx]==N){
            return ;
        }

        //////////////////////////////////
//        System.out.println(gate[idx]+" "+cnt+" "+dir);
//        for(int i=1;i<N+1;i++){
//            System.out.print(isOpen[i]+" ");
//        }
//
//        System.out.println("\n-----------");
        ////////////////////////////////

        int nowIdx=gate[idx];
        for(int i=0;i<2;i++){
            int tmpIdx=0;
            int nextCnt=0;
            if(!isOpen[nowIdx]) {
                if (dir == 0) { //왼쪽으로.
                    tmpIdx=nowIdx;
                    while(tmpIdx>=1 && !isOpen[tmpIdx]){
                        tmpIdx--;
                    }
                    if(tmpIdx==0){
                        continue;
                    }
                    nextCnt=nowIdx-tmpIdx;
                }
                else if(dir==1){ //오른쪽으로.
                    tmpIdx=nowIdx;
                    while(tmpIdx<N+1 && !isOpen[tmpIdx]){
                        tmpIdx++;
                    }
                    if(tmpIdx==N+1){
                        continue;
                    }
                    nextCnt=tmpIdx-nowIdx;

                }
                isOpen[nowIdx]=true;
                isOpen[tmpIdx]=false;
                solve(idx+1,cnt+nextCnt,i);
                isOpen[nowIdx]=false;
                isOpen[tmpIdx]=true;
            }
            else{
                solve(idx+1,cnt,i);
            }
        }

    }
}
/*
8
1 8
3
4
1
8
->6

8
1 8
2
1
8
->0

5
2 3
4
1
4
1
5
->3
* */