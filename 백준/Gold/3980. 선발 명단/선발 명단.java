import java.util.*;
import java.io.*;
public class Main {
    static int T;
    static int[] ch;
    static int[][] arr;
    static int[] res;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans=new StringBuilder();
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            arr=new int[11][11];
            ch=new int[11];
            res=new int[11];
            answer=0;
            for(int i=0;i<11;i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j=0;j<11;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            permutation(0);
            ans.append(answer+"\n");
        }
        bw.flush();
        bw.write(ans.toString());
        bw.close();
    }
    public static void permutation(int cnt){
        if(cnt==11){
            int sum=0;
            for(int i=0;i<11;i++){
                sum+=arr[i][res[i]];
            }
            answer=Math.max(answer,sum);
            return ;
        }
        for(int i=0;i<11;i++){
            if(ch[i]==0 && arr[cnt][i]!=0){
                ch[i]=1;
                res[cnt]=i;
                permutation(cnt+1);
                ch[i]=0;
            }
        }

    }
}