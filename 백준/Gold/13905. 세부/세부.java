import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int s,e;//s : 출발, e : 도착
    static class Node{
        int n;
        int w;
        public Node(int n,int w){
            this.n=n;
            this.w=w;
        }
    }
    static ArrayList<Node>[] arr;
    static int[] ch;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        s=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        ch=new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        int max=0;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            arr[n1].add(new Node(n2,w));
            arr[n2].add(new Node(n1,w));
            max=Math.max(max,w);
        }
        int left=0;
        int right=max;
        int mid=0;
        int answer=0;
        boolean fl=true;
        while(left<=right){
            mid=(left+right)/2;
            ArrayDeque<Integer> q=new ArrayDeque<>();
            ch=new int[N+1];
            q.add(s);
            boolean flag=false;
            while(!q.isEmpty()){
                int now=q.poll();
                if(now==e){
                    flag=true;
                    fl=false;
                    break;
                }
                ch[now]=1;
                for(int i=0;i<arr[now].size();i++){
                    Node next=arr[now].get(i);
                    int nextNode=next.n;
                    int nextW=next.w;
                    if(ch[nextNode]==0 && nextW>=mid){
                        ch[nextNode]=1;
                        q.add(nextNode);
                    }
                }
            }
            if(flag){
                answer=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        if(fl){
            answer=0;
        }
        System.out.println(answer);
    }
}
/*
7 6
1 5
1 2 2
1 7 4
2 3 5
3 7 5
4 6 1
6 7 4
* */