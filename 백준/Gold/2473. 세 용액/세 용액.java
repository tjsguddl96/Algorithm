import java.io.*;
import java.util.*;

public class Main {
    //일단 용액의 특성값은 long으로 선언
    static int N;
    static long[] arr;
    static StringBuilder ans=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        arr=new long[N];
        for(int i=0;i<N;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long answer=Long.MAX_VALUE;
        long[] res=new long[3];
        int flag=0;
        for(int i=0;i<N-2;i++){
            int left=i+1;
            int right=N-1;
            while(left<right){
                long temp=arr[i]+arr[left]+arr[right];
                if(answer>Math.abs(temp)){
                    answer=Math.abs(temp);
                    res[0]=arr[i];
                    res[1]=arr[left];
                    res[2]=arr[right];
                }
                if(temp==0){
                    res[0]=arr[i];
                    res[1]=arr[left];
                    res[2]=arr[right];
                    flag=1;
                    break;
                }
                else if(temp>0){
                    right-=1;
                }
                else{
                    left+=1;
                }
            }
            if(flag==1){
                break;
            }
        }
        Arrays.sort(res);
        for(int i=0;i<res.length;i++){
            ans.append(res[i]+" ");
        }
        System.out.println(ans);
    }
}