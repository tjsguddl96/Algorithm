import java.util.*;
import java.io.*;
public class Main {
    static int N,K;
    static Stack<Integer> s=new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        String str=bf.readLine();
        int now=0;
        int k=0;
        for(int i=0;i<N;i++){
            now=str.charAt(i)-'0';
            if(s.isEmpty()){
                s.add(now);
            }
            else{
                while(!s.isEmpty() && k<K && s.peek()<now){
                    s.pop();
                    k++;
                }
                s.add(now);
            }

        }
        int[] answer=new int[N-K];
        if(s.size()>N-K){
            int size=s.size();
            for(int i=0;i<size-(N-K);i++){
                s.pop();
            }
        }
        for(int i=N-K-1;i>=0;i--){
            answer[i]=s.pop();
        }
        for(int i=0;i<N-K;i++){
            ans.append(answer[i]);
        }

        bw.flush();
        bw.write(ans.toString());
        bw.close();
    }
}
/*
4 2
1924
//answer : 94

7 3
1231234
//answer : 3234

10 4
4177252841
//answer : 775841

6 2
391123
//answer : 9123

6 2
436436
//answer: 6436

7 3
7654321
//answer: 7654

6 2
362514
//answer : 6514

2 1
19
//answer : 9

4 2
1324
//answer : 34

4 1
8849
//answer: 889

8 2
15446321
//answer : 546321

7 5
9929191
//answer : 99

5 3
99291
//answer : 99

6 3
773671
//answer : 777

4 2
9879
//answer : 99

10 3
2222211113
//answer : 2222213

10 3
1111122223
//answer : 1122223


* */