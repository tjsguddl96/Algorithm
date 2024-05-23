import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] w;
    static ArrayList<Integer>[] arr;
    static class Node{
        int me;
        int notMe;
        ArrayList<Integer> Me;
        ArrayList<Integer> NotMe;
        public Node(int me,int notMe,ArrayList<Integer> Me,ArrayList<Integer> NotMe){
            this.me=me;
            this.notMe=notMe;
            this.Me=Me;
            this.NotMe=NotMe;
        }
    }
    static int start;
    static Node[] nodes;
    static int[] ch;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        w=new int[N+1];
        ch=new int[N+1];
        arr=new ArrayList[N+1];
        nodes=new Node[N+1];
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            w[i]=Integer.parseInt(st.nextToken());
            arr[i]=new ArrayList<>();
            nodes[i]=new Node(0,0,new ArrayList<>(),new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
        }
        start=1;
        dfs(start);
//        for(int i=1;i<N+1;i++){
//            System.out.print(i+" ");
//            System.out.println(nodes[i].me+" "+nodes[i].notMe);
//        }
        if(nodes[start].me>nodes[start].notMe){
            System.out.println(nodes[start].me);
            Collections.sort(nodes[start].Me);
            for(int i=0;i<nodes[start].Me.size();i++){
                System.out.print(nodes[start].Me.get(i)+" ");
            }
        }
        else{
            System.out.println(nodes[start].notMe);
            Collections.sort(nodes[start].NotMe);
            for(int i=0;i<nodes[start].NotMe.size();i++){
                System.out.print(nodes[start].NotMe.get(i)+" ");
            }
        }
    }
    public static void dfs(int nowNode){
        ch[nowNode]=1;
//        System.out.println("지금 "+nowNode);
//        System.out.print("ch : ");
//        for(int i=1;i<N+1;i++){
//            System.out.print(ch[i]+" ");
//        }
//        System.out.println();
        if(nowNode!=start && arr[nowNode].size()==1){
            nodes[nowNode].me=w[nowNode];
            nodes[nowNode].Me.add(nowNode);
            return ;
        }
        for(int i=0;i<arr[nowNode].size();i++){
            int next=arr[nowNode].get(i);
            if(ch[next]==0) {
                dfs(next);
                nodes[nowNode].me+=nodes[next].notMe;
                for(int j=0;j<nodes[next].NotMe.size();j++){
                    nodes[nowNode].Me.add(nodes[next].NotMe.get(j));
                }
                if(nodes[next].me>nodes[next].notMe){
                    nodes[nowNode].notMe+=nodes[next].me;
                    for(int j=0;j<nodes[next].Me.size();j++){
                        nodes[nowNode].NotMe.add(nodes[next].Me.get(j));
                    }
                }
                else{
                    nodes[nowNode].notMe+=nodes[next].notMe;
                    for(int j=0;j<nodes[next].NotMe.size();j++){
                        nodes[nowNode].NotMe.add(nodes[next].NotMe.get(j));
                    }
                }
            }
//            System.out.println(nowNode+"의 자식 "+next);
        }
        nodes[nowNode].me+=w[nowNode];
        nodes[nowNode].Me.add(nowNode);
    }


}