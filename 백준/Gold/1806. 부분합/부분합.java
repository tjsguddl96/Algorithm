import java.util.*;
import java.io.*;

public class Main {
    static int N,S;
    static int[] input;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        input=new int[N];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            input[i]=Integer.parseInt(st.nextToken());
        }
        int left=0;
        int right=0;
        long sum=input[right];
        int answer=Integer.MAX_VALUE;
        while(left<N){
//            System.out.println(input[left]+" "+input[right]);
            if(sum<S){
                right++;
                if(right>=N){
                    break;
                }
                sum+=input[right];
            }
            else{
                answer=Math.min(answer,right-left+1);
                sum-=input[left];
                left++;
            }
        }
        if(answer==Integer.MAX_VALUE){
            answer=0;
        }
        System.out.println(answer);

    }
}

/*
6 1
5 2 7 1 10 1
->1

6 7
5 1 3 5 10 7
->1

8 7
5 1 3 5 10 7 5 2
->1

6 200
5 1 3 5 10 7
-> 0

5 15
1 2 3 4 5
-> 5

10 5
5 2 3 2 3 2 3 2 3 2
->1

5 100
1 1 100 1 1
->1
* */