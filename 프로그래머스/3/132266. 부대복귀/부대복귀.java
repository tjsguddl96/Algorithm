import java.util.*;
import java.io.*;
class Solution {
    static class Dist{
        int dist;
        int n;
        public Dist(int dist,int n){
            this.dist=dist;
            this.n=n;
        }
    }
    static int[] ch;
    static ArrayDeque<Dist> q=new ArrayDeque<>();
    // static int[][] dist;
    static ArrayList<Integer>[] arr;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        ch=new int[n+1];
        arr=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            arr[i]=new ArrayList<>();
            ch[i]=-1;
        }
        for(int i=0;i<roads.length;i++){
            int n1=roads[i][0];
            int n2=roads[i][1];
            arr[n1].add(n2);
            arr[n2].add(n1);
        }
        q.add(new Dist(0,destination));
        ch[destination]=0;
        bfs();
        answer=new int[sources.length];
        for(int i=0;i<sources.length;i++){
            int ans=sources[i];
            answer[i]=ch[ans];
        }
        return answer;
    }
    
    public void bfs(){
        while(!q.isEmpty()){
            Dist now=q.poll();
            int nowN=now.n;
            int nowD=now.dist;
            for(int i=0;i<arr[nowN].size();i++){
                int nextN=arr[nowN].get(i);
                int nextD=nowD+1;
                if(ch[nextN]==-1){
                    ch[nextN]=nextD;
                    q.add(new Dist(nextD,nextN));
                }
            }
        }
    }
}