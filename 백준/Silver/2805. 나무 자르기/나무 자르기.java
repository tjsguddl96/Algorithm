import java.util.*;
import java.io.*;

public class Main {
    static int n; //n:나무 갯수, m: 필요한 나무 길이
    static long m;
    static long[] trees;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Long.parseLong(st.nextToken());
        trees=new long[n];
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            trees[i]=Long.parseLong(st.nextToken());
        }

        Arrays.sort(trees);
        long right=trees[n-1];
        long left=0;
        while(left<=right){
            long mid=(right+left)/2;
            long sum=0;
            for(int i=n-1;i>=0;i--){
                if(trees[i]<mid){
                    break;
                }
                sum+=(trees[i]-mid);
            }
            if(sum<m){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        System.out.println(right);

    }
}