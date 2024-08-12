import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static long answer;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        arr=new int[N];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        HashSet<Integer> set=new HashSet<>();
        int left=0;
        int right=0;
        while(left<N){
//            if(right==N){
//                answer+=((right-left)*(right-left+1)/2);
//                break;
//            }
            if(right<N && (set.isEmpty() || !set.contains(arr[right]))){
                set.add(arr[right]);
                right++;
            }
            else{
                answer+=(right-left);
                set.remove(Integer.valueOf(arr[left]));
                left++;
            }
        }
        System.out.println(answer);
    }
}
/*
6
1 2 3 4 1 2
-> 18

6
1 2 3 4 1 4
-> 16

5
1 2 2 2 1
->7


15
1 2 3 2 1 1 2 3 2 1 1 2 3 2 1
->33

6
1 5 6 2 6 3
->15

6
1 5 6 2 7 6
->18

4
1 3 5 1
*/