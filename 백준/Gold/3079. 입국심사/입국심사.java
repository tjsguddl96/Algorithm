import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] t;
    static long answer,left,right,mid;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken()); //입국심사대
        m=Integer.parseInt(st.nextToken()); //친구수

        t=new int[n];

        for(int i=0;i<n;i++){
            t[i]=Integer.parseInt(br.readLine());
            if(right<t[i]){
                right=t[i];
            }
        }

        right*=m;

        while(left<=right) {
            mid = (left + right) / 2;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += (mid / t[i]);
                if (cnt > m) {
                    break;
                }
            }
            if (cnt >= m) {
                right = mid-1;
            } else {
                left = mid + 1;
                mid=left;
            }
        }
        System.out.println(mid);
    }
}