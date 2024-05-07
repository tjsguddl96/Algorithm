import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static class Road implements Comparable<Road>{
        int n1;
        int n2;
        int num;
        public Road(int n1,int n2,int num){
            this.n1=n1;
            this.n2=n2;
            this.num=num;
        }
        @Override
        public int compareTo(Road o){
            return this.num-o.num;
        }
    }
    static int N,M;
    static PriorityQueue<Road> pq=new PriorityQueue<>();
    static PriorityQueue<Road> pq2=new PriorityQueue<>();
    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        answer=new int[N];
        int cnt=1;
        for(int i=0;i<N;i++){
            String input=bf.readLine();
            for(int j=0;j<N;j++){
                char now=input.charAt(j);
                if(j<i){
                    continue;
                }
                if(now=='Y'){
                    pq.add(new Road(i,j,cnt));
                    cnt++;
                }
            }
        }
        parent=new int[N];
        int flag=0;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int tmp=0;
//        System.out.println(pq.size()+" pq size");

        while (!pq.isEmpty()) {
            Road now = pq.poll();
            int n1 = now.n1;
            int n2 = now.n2;
            if (findParent(n1) != findParent(n2)) {
                union(n1, n2);
//                System.out.println(n1+" "+n2);
                answer[n1]++;
                answer[n2]++;
                tmp++;
            }
            else{
                pq2.add(new Road(n1,n2,now.num));
            }
        }
//        System.out.println("tmp : "+tmp);
        tmp=M-tmp;
//        System.out.println("tmp : "+tmp);
        if(tmp>0){
            while(tmp>0 && !pq2.isEmpty()){
                Road now=pq2.poll();
                int n1=now.n1;
                int n2=now.n2;
                answer[n1]++;
                answer[n2]++;
                tmp--;
            }
        }
        if(tmp!=0){
            flag=1;
        }
        for (int i = 0; i < N; i++) {
            if (findParent(i) != 0) {
                flag = 1;
                break;
            }
        }

        if(flag==0){
            for(int i=0;i<N;i++){
                ans.append(answer[i]+" ");
            }
            bw.flush();
            bw.write(ans.toString());
            bw.close();
        }
        else{
            System.out.println(-1);
//            for(int i=0;i<N;i++){
//                ans.append(answer[i]+" ");
//            }
//            bw.flush();
//            bw.write(ans.toString());
//            bw.close();
        }
    }
    public static int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return findParent(parent[x]);
    }
    public static void union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);
        if(parentA==parentB){
            return ;
        }
        else if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }
}
/*
4 3
NYYN
YNYN
YYNY
NNYN
-> 2 1 2 1

8 7
NYYNYYYN
YNNNNYYN
YNNNYNNN
NNNNNNYY
YNYNNNNN
YYNNNNYY
YYNYNYNY
NNNYNYYN

8 8
NYYNYYYN
YNNNNYYN
YNNNYNNN
NNNNNNYY
YNYNNNNN
YYNNNNYY
YYNYNYNY
NNNYNYYN
* */