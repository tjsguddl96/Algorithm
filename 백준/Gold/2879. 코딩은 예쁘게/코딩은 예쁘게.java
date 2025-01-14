import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] origin;
    static int[] tobe;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        origin=new int[N];
        tobe=new int[N];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            origin[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            int n=Integer.parseInt(st.nextToken());
            tobe[i]=n-origin[i];
        }

        answer=Math.abs(tobe[N-1]);
        int prev=tobe[0];
        for(int now=1;now<N;now++){
            if(prev*tobe[now]<0){ //부호가 다름
                answer+=Math.abs(prev);
            }
            else{ //부호가 같음
                if(Math.abs(prev)>Math.abs(tobe[now])){ //감소하는 경우
                    answer+=Math.abs(prev-tobe[now]);
                }
            }
            prev=tobe[now];
        }





        System.out.println(answer);
    }
}
/*
6
5 4 3 2 5 4
5 4 1 2 3 1
->5

3
1 2 3
1 2 3
->0

7
5 4 5 5 4 6 7
1 5 0 1 2 10 0

7
5 4 5 5 4 6 7
1 5 0 1 2 10 14


3
0 0 0
4 2 4
->6
4
0 0 0 0
4 2 4 6
-> 8
* */