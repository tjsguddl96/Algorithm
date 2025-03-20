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
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(bf.readLine());
        }
        int answer=Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            int target=arr[i]+M;
            int left=i;
            int right=N-1;
            int mid=0;
            int Mid=0;
            while(left<=right){
                mid=(left+right)/2;
                if(arr[mid]<target){
                    left=mid+1;
                }
                else{
                    answer=Math.min(arr[mid]-arr[i],answer);
                    right=mid-1;
                }
            }
        }
        System.out.println(answer);
    }

}
