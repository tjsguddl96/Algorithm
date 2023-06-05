import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static long[] time;
    public static void main(String[] args) throws Exception {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        time=new long[n];
        for(int i=0;i<n;i++){
            time[i]=Long.parseLong(bf.readLine());
        }
        Arrays.sort(time);
        long left=time[0];
        long right=time[0]*m;
        long p=0L;
        long mid=0;
        while(left<=right){
            mid=(left+right)/2;
            p=0;
            for(int i=0;i<n;i++){
                if(time[i]>mid){
                    break;
                }
                p+=(mid/time[i]);
            }
            if(p>=m){
                right=mid-1;
            }else{
                left=mid+1;
                mid=left;
            }
        }
        System.out.println(mid);
    }
}