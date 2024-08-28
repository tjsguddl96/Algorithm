import java.util.*;
import java.io.*;
public class Main {
    static int D,K;
    static int A,B;
    static int[] aCnt;
    static int[] bCnt;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        D=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        aCnt=new int[D+1];
        bCnt=new int[D+1];
        aCnt[1]=1;
        aCnt[2]=0;
        aCnt[3]=1;
        bCnt[1]=0;
        bCnt[2]=1;
        solveA(D);
        solveB(D);
        for(int i=1;i<=K;i++){
            if((K-aCnt[D]*i)%bCnt[D]==0){
                A=i;
                B=(K-aCnt[D]*i)/bCnt[D];
                break;
            }
        }
        System.out.println(A);
        System.out.println(B);
    }
    public static int solveA(int day){
        if(day<=3){
            return aCnt[day];
        }
        aCnt[day]=solveA(day-1)+solveA(day-2);
        return aCnt[day];
    }
    public static int solveB(int day){
        if(day<=2){
            return bCnt[day];
        }
        bCnt[day]=solveB(day-1)+solveB(day-2);
        return bCnt[day];
    }
}