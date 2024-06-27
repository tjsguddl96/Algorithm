import java.util.*;
import java.io.*;
public class Main {
    static int answer=Integer.MAX_VALUE;
    static int N;
    static int[][] arr;
    static int[] ch;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        arr=new int[N+1][N+1];
        ch=new int[N+1];
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<N+1;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        combi(0,1);
        System.out.println(answer);

    }
    public static void combi(int cnt,int start){
        if(answer==0){
            return ;
        }
        if(cnt==N/2){
            int t1=0;
            int t2=0;
            for(int i=1;i<N;i++){
                for(int j=i+1;j<N+1;j++){
                    if(ch[i]==1 && ch[j]==1){
                        t1+=arr[i][j];
                        t1+=arr[j][i];
                    }
                    else if(ch[i]==0 && ch[j]==0){
                        t2+=arr[i][j];
                        t2+=arr[j][i];
                    }
                }
            }

            answer=Math.min(answer,Math.abs(t1-t2));
            
            return ;
        }
        for(int i=start;i<N+1;i++){
            if(ch[i]==0){
                ch[i]=1;
                combi(cnt+1,i+1);
                ch[i]=0;
            }
        }

    }
}