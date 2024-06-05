import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static class Node{
        int n;
        int d;
        public Node(int n,int d){
            this.n=n;
            this.d=d;
        }

    }
    static ArrayList<Node>[] arr;
    static int[] ch;
    static int maxVal;
    static int maxIdx;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        arr=new ArrayList[N+1];
        ch=new int[N+1];
        for(int i=0;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            arr[n1].add(new Node(n2,d));
            arr[n2].add(new Node(n1,d));
        }
        ch[1]=1;
        dfs(1,0);
        ch=new int[N+1];
        ch[maxIdx]=1;
        maxVal=0;
        dfs(maxIdx,0);
        System.out.println(maxVal);

    }
    public static void dfs(int nowNode,int nowD){
        if(nowD>maxVal){
            maxVal=nowD;
            maxIdx=nowNode;
        }
        for(int i=0;i<arr[nowNode].size();i++){
            Node next=arr[nowNode].get(i);
            int nextNode=next.n;
            int nextD=next.d;
            if(ch[nextNode]==0){
                ch[nextNode]=1;
                dfs(nextNode,nowD+nextD);
            }
        }
    }

}