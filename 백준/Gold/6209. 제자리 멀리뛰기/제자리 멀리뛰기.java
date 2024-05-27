import java.util.*;
import java.io.*;

public class Main {
    static int d,n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        d=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n+2];
        arr[0]=0;
        arr[n+1]=d;
        for(int i=1;i<n+1;i++){
            arr[i]=Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        int left=1;
        int right=d;
        int mid=0;
        int Mid=0;
        while(left<=right){
            mid=(left+right)/2;
            int cnt=0;
            int tmp=0;
            for(int i=1;i<n+2;i++){
                if(arr[i]-tmp>=mid){
                    tmp=arr[i];
                    cnt++;
                }
            }
//            System.out.println(left+" "+right+" "+mid+" "+cnt);
            if(cnt<n-m+1){
                right=mid-1;
            }
            else{
                Mid=mid;
                left=mid+1;
            }
        }
        if(m==n){
            Mid=d;
        }
            System.out.println(Mid);

    }
}
/*
25 5 4
2
14
11
21
17
->11

25 5 5
2
14
11
21
17
->25

11 2 0
4
8
->3

* */