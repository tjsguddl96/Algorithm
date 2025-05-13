import java.util.*;
import java.io.*;
public class Main {
    static int K,N;
    static int[] arr;
    static long right=Integer.MAX_VALUE,left,answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        K=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        arr=new int[K];
        for(int i=0;i<K;i++){
            arr[i]=Integer.parseInt(bf.readLine());
        }

        while(left<=right){
            long mid=(left+right)/2;
            long tmp=0;
            for(int i=0;i<K;i++){
                tmp+=(arr[i]/mid);
            }
            if(tmp>=N){ //더 크게
                left=mid+1;
                answer=mid;
            }
            else{ //더 작게
                right=mid-1;
            }
        }
        System.out.println(answer);







    }
}
