import java.util.*;
class Solution {
    static int[] incoming;
    static int N,M;//N=a의 사이즈, M=edges의 사이즈
    static ArrayList<Integer>[] arr;
    static ArrayDeque<Integer> q=new ArrayDeque<>();
    static long[] tmp;
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        N=a.length;
        M=edges.length;
        incoming=new int[N];
        tmp=new long[N];
        arr=new ArrayList[N];
        for(int i=0;i<N;i++){
            arr[i]=new ArrayList<>();
            tmp[i]=(long)a[i];
        }
        for(int i=0;i<M;i++){
            int n1=edges[i][0];
            int n2=edges[i][1];
            arr[n1].add(n2);
            arr[n2].add(n1);
            incoming[n1]++;
            incoming[n2]++;
        }
        for(int i=0;i<N;i++){
            if(incoming[i]==1){
                q.add(i);
                incoming[i]-=1;
            }
        }
        if(N==2){
            if(a[0]==(-1)*a[1]){
                return Math.abs(a[0]);
            }
        }
        
        while(!q.isEmpty()){
            int now=q.poll();
            long num=tmp[now];
            if(q.isEmpty() && tmp[now]!=0){
                answer=-1;
                break;
            }
            if(num<0){
                answer+=((-1)*num);
            }
            else{
                answer+=num;
            }
            tmp[now]=0;
            incoming[now]=0;
            for(int i=0;i<arr[now].size();i++){
                int next=arr[now].get(i);
                if(incoming[next]==0){
                    continue;
                }
                tmp[next]+=num;
                incoming[next]--;
                if(incoming[next]==1){
                    q.add(next);
                }
            }
            // System.out.println(now+" "+answer);
            // for(int i=0;i<N;i++){
            //     System.out.print (i+" : "+a[i]+" // ");
            // }
            // System.out.println();
        }
        for(int i=0;i<N;i++){
            if(tmp[i]!=0){
                answer=-1;
                break;
            }
        }
        
        return answer;
    }
}