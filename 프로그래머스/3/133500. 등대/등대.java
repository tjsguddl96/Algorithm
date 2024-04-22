import java.util.*;
class Solution {
    static int[] light;
    static ArrayList<Integer>[] arr;
    static int[] incoming;
    static ArrayDeque<Integer> q=new ArrayDeque<>();
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        light=new int[n+1];
        incoming=new int[n+1];
        arr=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<lighthouse.length;i++){
            int n1=lighthouse[i][0];
            int n2=lighthouse[i][1];
            arr[n1].add(n2);
            arr[n2].add(n1);
            incoming[n1]++;
            incoming[n2]++;
        }
        for(int i=1;i<n+1;i++){
            if(incoming[i]==1){
                q.add(i);
                incoming[i]--;
            }
        }
        while(!q.isEmpty()){
            int now=q.poll();
            for(int i=0;i<arr[now].size();i++){
                int next=arr[now].get(i);
                incoming[next]--;
                if(incoming[next]==1){
                    q.add(next);
                }
                if(light[now]==0){
                    light[next]=1;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            if(light[i]==1){
                answer++;
            }
        }
        
        
        return answer;
    }
    
}