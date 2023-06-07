import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] res=new int[2];
    static Queue<dis> q=new ArrayDeque<>();
    static ArrayList<Integer> arr[];
    static int[] ch;
    static int[] distance;
    static int[] ansNode=new int[2];
    static int ans=Integer.MAX_VALUE;
    static class dis{
        int node;
        int dist;
        public dis(int node,int dist){
            this.node=node;
            this.dist=dist;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new ArrayList[n+1];


        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
        }



        combination(0,1);
        System.out.println(ansNode[0]+" "+ansNode[1]+" "+ans);
    }
    public static void combination(int cnt,int start){
        if(cnt==2){
            ch=new int[n+1];
            distance=new int[n+1];
            ch[res[0]]=1;
            ch[res[1]]=1;
            q.add(new dis(res[0],0));
            q.add(new dis(res[1],0));
            int distance=0;
            while(!q.isEmpty()){
                dis now=q.poll();
                int nowNode=now.node;
                int nowDist=now.dist;
                distance+=nowDist;
                for(int i=0;i<arr[nowNode].size();i++){
                    if(ch[arr[nowNode].get(i)]==0){
                        ch[arr[nowNode].get(i)]=1;
                        q.add(new dis(arr[nowNode].get(i),nowDist+1));
                    }
                }

            }
            distance*=2;
            if(distance<ans){
                ans=distance;
                ansNode[0]=res[0];
                ansNode[1]=res[1];
            }
            return ;
        }
        for(int i=start;i<=n;i++){
            res[cnt]=i;
            combination(cnt+1,i+1);
        }
    }
}