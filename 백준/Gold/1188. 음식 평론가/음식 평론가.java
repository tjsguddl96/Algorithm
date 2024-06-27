import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        if(N%M==0){
            answer=0;
        }
        else{
            int rest=0;
            for(int i=0;i<N;i++){
                int bread=M-rest;
                int cnt=bread/N;
                answer+=cnt;
                if(bread%N==0){
                    answer--;
                }
                rest=N-bread%N;
                if(rest%N!=0){
                    answer++;
                }
                else{
                    rest=0;
                }
            }
        }
        System.out.println(answer);
    }
}
/*
2 5
-> 4
* */