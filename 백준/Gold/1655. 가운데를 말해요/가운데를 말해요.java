import java.util.*;
import java.io.*;
public class Main {
    static class Max implements Comparable<Max>{
        int n;
        public Max(int n){
            this.n=n;
        }
        @Override
        public int compareTo(Max o){
            return o.n-this.n;
        }
    }
    static int N;
    static PriorityQueue<Integer> pqMin=new PriorityQueue<>();
    static PriorityQueue<Max> pqMax=new PriorityQueue<>();
    static ArrayList<Integer> answer=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(bf.readLine());

        for(int i=1;i<N+1;i++){
            int n=Integer.parseInt(bf.readLine());
            if(pqMax.isEmpty()){
                pqMax.add(new Max(n));
                answer.add(n);
            }else{
                if(pqMin.isEmpty()){
                    if(pqMax.peek().n>n){
                        pqMin.add(pqMax.poll().n);
                        pqMax.add(new Max(n));
                    }
                    else{
                        pqMin.add(n);
                    }
                }
                else {
                    if (n > pqMin.peek()) { //최소힙으로
                        pqMin.add(n);
                    }
                    else if ((n <= pqMax.peek().n) || (n > pqMax.peek().n && n <= pqMin.peek())) { //최대힙으로
                        pqMax.add(new Max(n));
                    }
                    if (i % 2 == 0) { //짝수일 때
                        if (pqMax.size() > (i / 2)) {
                            pqMin.add(pqMax.poll().n);

                        } else if (pqMax.size() < (i / 2)) {
                            pqMax.add(new Max(pqMin.poll()));

                        }
                    } else { //홀수일 때
                        if (pqMax.size() > (i / 2) + 1) {
                            pqMin.add(pqMax.poll().n);

                        } else if (pqMax.size() < (i / 2) + 1) {
                            pqMax.add(new Max(pqMin.poll()));

                        }
                    }
                }
                answer.add(pqMax.peek().n);
            }

        }
        for(int i=0;i<answer.size();i++){
            bw.write(answer.get(i)+"\n");
        }
        bw.flush();
        bw.close();
    }
}
/*
10
5
10
15
20
11
12
11
4
14
11
->
5
5
10
10
11
11
11
11
11
11

* */