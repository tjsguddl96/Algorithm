import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static int[] dist;
    static class Node{
        int n;
        int d;
        public Node(int n,int d){
            this.n=n;
            this.d=d;
        }
    }
    static ArrayDeque<Node> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        dist=new int[300005];
        for(int i=0;i<300005;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[N]=0;
        q.add(new Node(N,0));
        while(!q.isEmpty()){
            Node now=q.poll();
            int nowNode=now.n;
            int nowD=now.d;
            int nextNode1=nowNode+1;
            int nextD1=nowD+1;
            if(nextNode1>=0 && nextNode1<300005 && dist[nextNode1]>nextD1){
                dist[nextNode1]=nextD1;
                q.add(new Node(nextNode1,dist[nextNode1]));
            }
            int nextNode2=nowNode-1;
            int nextD2=nowD+1;
            if(nextNode2>=0 && nextNode2<300005 && dist[nextNode2]>nextD2){
                dist[nextNode2]=nextD2;
                q.add(new Node(nextNode2,dist[nextNode2]));
            }
            int nextNode3=nowNode*2;
            int nextD3=nowD;
            if(nextNode3>=0 && nextNode3<300005 && dist[nextNode3]>nextD3){
                dist[nextNode3]=nextD3;
                q.add(new Node(nextNode3,dist[nextNode3]));
            }
        }
        System.out.println(dist[K]);
    }
}
/*
9 17
->1

5 10
->0

571 998 expect: 72, result: 427
453 852 expect: 27, result: 399
112 871 expect: 4, result: 107
68 397 expect: 20, result: 32
481 886 expect: 38, result: 405
554 951 expect: 79, result: 397
453 681 expect: 113, result: 228
176 561 expect: 37, result: 105
50 574 expect: 15, result: 23
205 771 expect: 13, result: 181
229 635 expect: 71, result: 89
340 472 expect: 104, result: 132
574 842 expect: 153, result: 268
176 643 expect: 16, result: 146
244 407 expect: 41, result: 163
185 570 expect: 43, result: 100
270 860 expect: 55, result: 160
16 110 expect: 3, result: 12
186 540 expect: 51, result: 84
68 124 expect: 6, result: 56
197 385 expect: 5, result: 188
547 979 expect: 58, result: 432
175 629 expect: 19, result: 140
134 400 expect: 34, result: 66
* */