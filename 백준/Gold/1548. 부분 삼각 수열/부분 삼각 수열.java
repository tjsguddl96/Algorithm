import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int n;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        if(n==1){
            System.out.println(1);
        }
        else if(n==0){
            System.out.println(0);
        }
        else {
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int left = 0;
            int right = 1;
            long min = arr[left] + arr[left + 1];
            while (right < n) {
                int now = arr[right];
                if (now < min) {
                    right++;
                } else {
                    left++;
                    min = arr[left] + arr[left + 1];
                }
                answer=Math.max(answer,right-left);
            }
            System.out.println(answer);
        }


    }
}
