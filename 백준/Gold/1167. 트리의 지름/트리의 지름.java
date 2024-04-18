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
    static int max;
    static int[] ch;
    static int maxNode;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        arr=new ArrayList[N+1];
        ch=new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            while(true){
                int n2=Integer.parseInt(st.nextToken());
                if(n2==-1){
                    break;
                }
                int d=Integer.parseInt(st.nextToken());
                arr[n1].add(new Node(n2,d));
            }
        }
        int startNode=0;
        for(int i=1;i<N+1;i++){
            if(arr[i].size()==1){
                startNode=i;
                break;
            }
        }
        dfs(startNode,0);
        ch=new int[N+1];
        dfs(maxNode,0);
        System.out.println(max);

    }
    public static void dfs(int nowNode,int nowD){
        ch[nowNode]=1;
        if(max<nowD){
            max=nowD;
            maxNode=nowNode;
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