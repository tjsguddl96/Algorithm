import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] sum;
    static int answer=Integer.MAX_VALUE;
    static int[] ch;
    static ArrayList<Integer> star=new ArrayList<>();
    static ArrayList<Integer> link=new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        arr=new int[N][N];
        sum=new int[N][N];
        ch=new int[N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                sum[i][j]=arr[i][j]+arr[j][i];
            }
        }
        solve(0);
        System.out.println(answer);
    }
    public static void solve(int idx){
        if(answer==0){
            System.out.println(answer);
            System.exit(0);
            return ;
        }
        if(idx==N){
            star=new ArrayList<>();
            link=new ArrayList<>();
            for(int i=0;i<N;i++){
                if(ch[i]==0){
                    star.add(i);
                }
                else{
                    link.add(i);
                }
            }
            if(star.size()==0||link.size()==0){
                return ;
            }
            int s=0;
            int l=0;
            for(int i=0;i<star.size();i++){
                for(int j=i+1;j<star.size();j++){
                    s+=sum[star.get(i)][star.get(j)];
                }
            }
            for(int i=0;i<link.size();i++){
                for(int j=i+1;j<link.size();j++){
                    l+=sum[link.get(i)][link.get(j)];
                }
            }
            answer=Math.min(answer,Math.abs(s-l));
            return ;
        }
        ch[idx]=1;
        solve(idx+1);
        ch[idx]=0;
        solve(idx+1);
        

    }
}