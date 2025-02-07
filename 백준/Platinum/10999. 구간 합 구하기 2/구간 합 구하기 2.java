import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static long[] arr;
    static long[] lazy;
    static long[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new long[N];
        tree=new long[4*N];
        lazy=new long[4*N];
        for(int i=0;i<N;i++){
            arr[i]=Long.parseLong(bf.readLine());
        }
        init(1,0,N-1);
        for(int i=0;i<M+K;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            if(a==1){
                int b=Integer.parseInt(st.nextToken());
                int c=Integer.parseInt(st.nextToken());
                long d=Long.parseLong(st.nextToken());
                updateRange(1,0,N-1,b-1,c-1,d);
            }
            else{
                int b=Integer.parseInt(st.nextToken());
                int c=Integer.parseInt(st.nextToken());
                long ans=findSum(1,0,N-1,b-1,c-1);
                answer.append(ans+"\n");
            }
        }

        bw.flush();
        bw.write(answer.toString());
        bw.close();

    }
    public static void init(int node,int start,int end){
        if(start==end){
            tree[node]=arr[start];
            return ;
        }
        int mid=(start+end)/2;
        init(node*2,start,mid);//왼쪽 자식
        init(node*2+1,mid+1,end); //오른쪽자식
        tree[node]=tree[node*2]+tree[node*2+1];
    }
    public static void updateLazy(int node,int start,int end){
        if(lazy[node]!=0){
            tree[node]+=lazy[node]*(end-start+1);
            if(start!=end){
                lazy[node*2]+=lazy[node];
                lazy[node*2+1]+=lazy[node];
            }
            lazy[node]=0;
        }
    }
    public static void updateRange(int node,int start,int end,int left,int right,long diff){
        updateLazy(node,start,end);
        if(end<left || right<start){
            return ;
        }
        else if(left<=start && end<=right){
            tree[node]+=(end-start+1)*diff;
            if(start!=end) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
        }
        else{
            int mid=(start+end)/2;
            updateRange(node*2,start,mid,left,right,diff);
            updateRange(node*2+1,mid+1,end,left,right,diff);
            tree[node]=tree[node*2]+tree[node*2+1];
        }
    }

    public static long findSum(int node,int start,int end,int left,int right){
        updateLazy(node,start,end);
        if(end<left||right<start){
            return 0;
        }
        else if(left<=start && end<=right){
            return tree[node];
        }
        int mid=(start+end)/2;
        long lSum=findSum(2*node,start,mid,left,right);
        long rSum=findSum(2*node+1,mid+1,end,left,right);
        return lSum+rSum;
    }


}
/*
5 2 3
1
2
3
4
5
1 1 5 1
2 1 5
2 2 2
1 1 5 -1
2 1 1
->
20
3
1


10 5 6
128947128
523982355
589435345
235091585
928353241
124789151
643683469
198623896
983258932
235892355
2 1 10
1 1 5 99999999
2 1 10
1 1 4 99999999
2 1 10
1 1 9 99999999
2 1 5
1 3 10 99999999
2 5 10
1 1 10 -99999999
2 1 10
->
4592057457
5092057452
5492057448
3805809640
4314601032
6192057441
* */