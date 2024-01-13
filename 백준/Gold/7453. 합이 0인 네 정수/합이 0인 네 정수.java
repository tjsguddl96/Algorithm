import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        int[][] arr=new int[n][4];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            arr[i][2]=Integer.parseInt(st.nextToken());
            arr[i][3]=Integer.parseInt(st.nextToken());
        }
        long[] arr1=new long[n*n];
        long[] arr2=new long[n*n];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr1[cnt]=arr[i][0]+arr[j][1];
                arr2[cnt]=arr[i][2]+arr[j][3];
                cnt++;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
        long answer=0;
        int left=0;
        int right=n*n-1;
        while(left<n*n && right>=0){
            long sum=arr1[left]+arr2[right];
            if(sum==0){
                long tempLeft=1;
                long tempRight=1;
                while((left+1)<=(n*n-1) && arr1[left]==arr1[left+1]){
                    tempLeft++;
                    left++;
                }
                while((right-1)>=0 && arr2[right]==arr2[right-1]){
                    tempRight++;
                    right--;
                }

                answer+=(tempLeft*tempRight);
                left++;
            }
            else if(sum>0L){
                right--;
            }
            else{
                left++;
            }
        }
        System.out.println(answer);
    }
}
/*
2
0 0 0 0
0 0 0 0

* */