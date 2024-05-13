import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static PriorityQueue<Integer> pq=new PriorityQueue<>();
    static int[] incoming;
    static ArrayList<Integer>[] arr; //arr[3]={1} => 3번->1번 이렇게 푸는게 유리
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        StringBuilder answer=new StringBuilder();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        incoming=new int[N+1];
        arr=new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            incoming[n2]++;
        }
        for(int i=1;i<N+1;i++){
            if(incoming[i]==0){
                pq.add(i);
            }
        }
        while(!pq.isEmpty()){
            int now=pq.poll();
            answer.append(now+" ");
            for(int i=0;i<arr[now].size();i++){
                int next=arr[now].get(i);
                incoming[next]--;
                if(incoming[next]==0){
                    pq.add(next);
                }
            }
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
}
/*
5 2
4 2
3 1
* */