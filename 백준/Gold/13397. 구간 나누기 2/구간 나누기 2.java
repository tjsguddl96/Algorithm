import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        st=new StringTokenizer(bf.readLine());
        int left=0;
        int right=0;
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(right<arr[i]){
                right=arr[i];
            }
        }
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(isMid(mid)){ //mid값을 더 크게
                left=mid+1;
            }
            else{ //mid값을 더 작게
                right=mid-1;
            }
        }
        System.out.println(left);
    }
    public static boolean isMid(int mid){ //isMid가 true이면 mid값을 더 크게(왜냐면 구간(cnt)가 M보다 크기 때문에 mid값을 더 크게 해줘야됨)
        int cnt=1;
        int max=0;
        int min=999999999;
        for(int i=0;i<N;i++){
            if(max<arr[i]){
                max=arr[i];
            }
            if(min>arr[i]){
                min=arr[i];
            }
            if((max-min)>mid){
                cnt+=1;
                max=arr[i];
                min=arr[i];
            }
        }
        if(cnt>M){
            return true;
        }
        return false;
    }
}