import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] ramen;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        ramen=new int[N+2];
        for(int i=0;i<N;i++){
            ramen[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            if(ramen[i+1]>ramen[i+2]){//이경우 2번 후 3번해야함
                //2번
                int m=Math.min(ramen[i],ramen[i+1]-ramen[i+2]);
                answer+=(m*5);
                ramen[i]-=m;
                ramen[i+1]-=m;
                //3번
                m=Math.min(ramen[i],Math.min(ramen[i+1],ramen[i+2]));
                answer+=(m*7);
                ramen[i]-=m;
                ramen[i+1]-=m;
                ramen[i+2]-=m;

            }
            else{ //3번
                int m=Math.min(ramen[i],Math.min(ramen[i+1],ramen[i+2]));
                answer+=(m*7);
                ramen[i]-=m;
                ramen[i+1]-=m;
                ramen[i+2]-=m;
            }
            answer+=ramen[i]*3;
            ramen[i]=0;
        }
        System.out.println(answer);


    }
}


/*
6
1 2 2 2 0 2
-> 23

5
1 2 0 3 4
->26

4
1 2 1 2

-> 15

* */