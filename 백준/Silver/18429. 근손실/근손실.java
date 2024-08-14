import java.io.*;
import java.util.*;
public class Main {
    static int N,K;
    static int[] arr;
    static int answer;
    static int[] ch;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[N];
        ch=new int[N];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        solve(0,500);
        System.out.println(answer);
    }
    public static void solve(int day,int w){
        if(day==N){
            answer++;
            return ;
        }
        for(int i=0;i<N;i++){
            if(w+arr[i]-K>=500 && ch[i]==0){
                ch[i]=1;
                solve(day+1,w+arr[i]-K);
                ch[i]=0;
            }
        }
    }
}