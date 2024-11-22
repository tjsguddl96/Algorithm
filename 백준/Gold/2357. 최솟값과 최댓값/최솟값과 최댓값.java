import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] arr;
    static class Query{
        int n1;
        int n2;
        public Query(int n1,int n2){
            this.n1=n1;
            this.n2=n2;
        }
    }
    static int[] treeMax;
    static int[] treeMin;
    static Query[] queries;
    static int INF=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        treeMax=new int[4*N];
        treeMin=new int[4*N];
        for(int i=0;i<4*N;i++){
            treeMin[i]=INF;
        }
        queries=new Query[M];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(bf.readLine());
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            queries[i]=new Query(n1,n2);
        }
        initMax(0,N-1,1);
        initMin(0,N-1,1);
        for(int i=0;i<M;i++){
            Query now=queries[i];
            int n1=now.n1;
            int n2=now.n2;
            int max=foundMax(0,N-1,n1-1,n2-1,1);
            int min=foundMin(0,N-1,n1-1,n2-1,1);
            answer.append(min+" "+max+"\n");
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
    public static void initMax(int start,int end,int now){
        if(start==end){ //리프 노드 -> 리프노드에 arr 저장
            treeMax[now]=arr[start];
            return ;
        }
        int mid=(start+end)/2;
        initMax(start,mid,now*2); //왼쪽 서브 트리
        initMax(mid+1,end,now*2+1); //오른쪽 서브 트리
        treeMax[now]=Math.max(treeMax[2*now],treeMax[2*now+1]);
    }
    //start,end => 조회할 범위
    //left,right => 조회할 쿼리의 범위
    public static int foundMax(int start,int end,int left,int right,int now){
        if(left<=start && end<=right){
            return treeMax[now];
        }
        else if(end<left || start>right){
            return 1;
        }
        int mid=(start+end)/2;
        int lMax=foundMax(start,mid,left,right,2*now);
        int rMax=foundMax(mid+1,end,left,right,2*now+1);
        return Math.max(lMax,rMax);
    }


    public static void initMin(int start,int end,int now){
        if(start==end){
            treeMin[now]=arr[start];
            return ;
        }
        int mid=(start+end)/2;
        initMin(start,mid,now*2);
        initMin(mid+1,end,now*2+1);
        treeMin[now]=Math.min(treeMin[now*2],treeMin[now*2+1]);
    }
    public static int foundMin(int start,int end,int left,int right,int now){
        if(left<=start && end<=right){
            return treeMin[now];
        }
        else if(right<start || left>end){
            return INF;
        }
        int mid=(start+end)/2;
        int lMin=foundMin(start,mid,left,right,now*2);
        int rMin=foundMin(mid+1,end,left,right,now*2+1);
        return Math.min(lMin,rMin);
    }
}