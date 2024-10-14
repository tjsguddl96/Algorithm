import java.io.*;
import java.util.*;
public class Main {
    static int N,L,R,X;
    static int[] prob;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        prob=new int[N];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            prob[i]=Integer.parseInt(st.nextToken());
        }
        combi(0,0,0,Integer.MAX_VALUE);
        System.out.println(answer);





    }
    public static void combi(int start,int sum,int max,int min){
        if(sum>=L && sum<=R && (max-min)>=X){
            answer++;
        }
        if(sum>R){
            return ;
        }

        for(int i=start;i<N;i++){
            combi(i+1,sum+prob[i],Math.max(max,prob[i]),Math.min(min,prob[i]));
        }

    }
}