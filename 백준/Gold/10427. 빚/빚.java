import java.util.*;
import java.io.*;
public class Main {
    static int T,N;
    static int[] num;
    static long[] sum;
    static long ans;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            ans=0L;
            st=new StringTokenizer(bf.readLine());
            N=Integer.parseInt(st.nextToken());
            num=new int[N+1];
            sum=new long[N+1];
            for(int i=1;i<N+1;i++){
                num[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);
            for(int i=1;i<N+1;i++){
                sum[i]=sum[i-1]+num[i];
            }
            for(int m=2;m<N+1;m++){
                long min=Long.MAX_VALUE;
                for(int i=m;i<N+1;i++){
                    long tmp=(m*num[i])-(sum[i]-sum[i-m]);
                    min=Math.min(tmp,min);
                }
                ans+=min;
            }
            answer.append(ans+"\n");
        }
        System.out.println(answer.toString());
    }
}