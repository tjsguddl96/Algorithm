import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] sum;
    static int[] left;
    static int[] right;
    static int[] s;
    static int min=Integer.MAX_VALUE;
    static int maxIdx;
    static int ansMax=Integer.MAX_VALUE;
    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        sum=new int[N+1];
        answer=new int[M];
        for(int i=1;i<N+1;i++){
            sum[i]=sum[i-1]+Integer.parseInt(st.nextToken());
        }
        left=new int[M];
        right=new int[M];
        s=new int[M];
        for(int i=0;i<M;i++){
            left[i]=i+1;
            right[i]=i+1;
        }
        right[M-1]=N; //i번 구간의 합 = sum[ri]-sum[li-1]
        while(left[M-1]<N+1){
            int max=0;
            min=Integer.MAX_VALUE;
//            System.out.println(ansMax+"~~");
            for(int i=0;i<M;i++){
                s[i]=sum[right[i]]-sum[left[i]-1];
//                System.out.println(i+" "+s[i]+" "+left[i]+" "+right[i]);
                if(max<s[i]){
                    max=s[i];
                    maxIdx=i;
                }
            }
//            System.out.println(minIdx+"!!");
//            System.out.println("-------");
            if(ansMax>max){
                ansMax=max;
                for(int i=0;i<M;i++){
                    answer[i]=right[i]-left[i]+1;
                }
            }
            if(maxIdx==0){
                break;
            }
            else {
                left[maxIdx]++;
                right[maxIdx-1]++;
            }
        }
        System.out.println(ansMax);
        for(int i=0;i<M;i++){
            System.out.print(answer[i]+" ");
        }


    }
}
/*
<input 1>
9 2
1 1 1 1 1 1 1 1 1
<output 1>
5
5 4

<input 2>
9 3
1 1 1 1 1 1 1 1 1
<output 2>
3
3 3 3

<input 3>
9 6
1 1 1 1 1 1 1 1 1
<output 3>
2
2 2 2 1 1 1

<input 4>
9 9
1 1 1 1 1 1 1 1 1
<output 4>
1
1 1 1 1 1 1 1 1 1

6 4
1 1 1 4 1 1

6 4
1 1 1 4 1 1

7 3
1 1 1 1 17 18 23

5 3
5 6 1 1 1

4 4
3 1 1 1

4 4
1 1 2 1

10 9
50 50 1 1 1 1 1 1 1 100

10 5
50 50 1 1 1 1 1 1 1 100

8 3
5 4 20 6 9 3 8 1
->
26
2 2 4
* */