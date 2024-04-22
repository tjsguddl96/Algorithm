import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] arr;
    static long[] incoming;
    static class Node{
        int n;
        long cnt;
        public Node(int n,long cnt){
            this.n=n;
            this.cnt=cnt;
        }
    }
    static class Animal{
        int n;
        long a;
        public Animal(int n,long a){
            this.n=n;
            this.a=a;
        }
    }
    static Animal[] animals;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        arr=new ArrayList[N+1];
        incoming=new long[N+1];
        animals=new Animal[N+1];
        animals[1]=new Animal(1,0L);
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            char t=st.nextToken().charAt(0);
            int a=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            if(t=='S'){
                animals[i+2]=new Animal(i+2,a);
            }
            else{
                animals[i+2]=new Animal(i+2,a*(-1));
            }
            arr[i+2].add(p);
            incoming[p]++;
        }
        ArrayDeque<Node> q=new ArrayDeque<>();
        for(int i=1;i<N+1;i++){
            if(incoming[i]==0){
                //Node(섬번호,양의 수)
                long animalCnt=animals[i].a;
                if(animals[i].a<0){
                    animalCnt=0;
                }
                q.add(new Node(i,animalCnt));
            }
        }
        while(!q.isEmpty()){
            Node now=q.poll();
            int nowNode=now.n;
            long nowCnt=now.cnt; //지금의 양의 수
            for(int i=0;i<arr[nowNode].size();i++){
                int nextNode=arr[nowNode].get(i);
                long nextCnt=animals[nextNode].a; //다음 늑대의 수 or 양의 수
                incoming[nextNode]--;
                animals[nextNode].a=nowCnt+nextCnt;
                if(incoming[nextNode]==0){
                    if(animals[nextNode].a<0L){
                        animals[nextNode].a=0L;
                    }
                    q.add(new Node(nextNode,animals[nextNode].a));
                }
            }
        }
        System.out.println(animals[1].a);



    }
}