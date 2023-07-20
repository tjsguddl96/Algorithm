import java.util.*;
class Dis{
    int node;
    long distance;
    public Dis(int node,long distance){
        this.node=node;
        this.distance=distance;
    }
}
class Solution {
    long[] dist;
    Deque<Dis> q=new ArrayDeque<>();
    public long solution(int n, int[][] edge) {
        long answer = 0;
        dist=new long[n+1]; //1에서 부터의 거리
        
        for(int i=0;i<edge.length;i++){
            int n1=edge[i][0];
            int n2=edge[i][1];
            if(n1==1){
                q.offer(new Dis(n2,1));
                dist[n2]=1;
            }else if(n2==1){
                q.offer(new Dis(n1,1));
                dist[n1]=1;
            }
        }
        dist[0]=-1;
        dist[1]=-1;
        BFS(n,edge);
        long max=0;
        for(int i=1;i<=n;i++){
            if(dist[i]>max){
                max=dist[i];
            }
        }
        for(int i=1;i<=n;i++){
            if(max==dist[i]){
                answer+=1;
            }
        }
        
        return answer;
    }
    public void BFS(int n,int[][] edge){
        while(!q.isEmpty()){
            Dis now=q.poll();
            int nowNode=now.node;
            long nowDist=now.distance;
            dist[nowNode]=Math.min(nowDist,dist[nowNode]);
          
            for(int i=0;i<edge.length;i++){
                int n1=edge[i][0];
                int n2=edge[i][1];
                if(n1==nowNode && dist[n2]==0){
                    dist[n2]=dist[nowNode]+1;
                    q.offer(new Dis(n2,dist[n2]));
                }
                else if(n2==nowNode && dist[n1]==0){
                    dist[n1]=dist[nowNode]+1;
                    q.offer(new Dis(n1,dist[n1]));
                }
            }
        }
    }
    
}