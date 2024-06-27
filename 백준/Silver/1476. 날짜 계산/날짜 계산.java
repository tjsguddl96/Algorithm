import java.util.*;
import java.io.*;

public class Main {
    static int E,S,M;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        E=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int answer=0;
        for(int i=1;i<Integer.MAX_VALUE;i++){
            int t1=i%15;
            int t2=i%28;
            int t3=i%19;
            if(t1==0){
                t1=15;
            }
            if(t2==0){
                t2=28;
            }
            if(t3==0){
                t3=19;
            }
            if(t1==E && t2==S && t3==M){
                answer=i;
                break;
            }
        }
        System.out.println(answer);

    }
}