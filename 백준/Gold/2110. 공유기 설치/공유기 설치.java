import java.util.*;
import java.io.*;

public class Main {
    static int N,C;
    static long[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        arr=new long[N];
        for(int i=0;i<N;i++){
            arr[i]=Long.parseLong(bf.readLine());
        }
        Arrays.sort(arr);
        long left=0;
        long right=arr[N-1]-arr[0];
        long mid=0L;
        long answer=0L;
        while(left<=right){
            long tmp=arr[0];
            long cnt=1L;
            mid=(right+left)/2;
            for(int i=0;i<N;i++){
                long t=arr[i]-tmp;
                if(mid<=t){
                    cnt++;
                    tmp=arr[i];
                }
                if(cnt>=C){
                    break;
                }
            }

            if(cnt<C){
                right=mid-1;
            }
            else{
                answer=mid;
                left=mid+1;
            }
        }
        System.out.println(answer);
    }
}