import java.util.*;

class Solution {
    static class Node{
        int on;
        int off;
        public Node(int on,int off){
            this.on=on;
            this.off=off;
        }
    }
    static int st;
    static int[] ch;
    static Node[] dp;
    static int ans=Integer.MAX_VALUE;
    static ArrayList<Integer>[] arr;
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        ch=new int[n+1];
        arr=new ArrayList[n+1];
        dp=new Node[n+1];
        for(int i=1;i<n+1;i++){
            arr[i]=new ArrayList<>();
            dp[i]=new Node(-1,-1);
        }
        for(int i=0;i<n-1;i++){
            int a=lighthouse[i][0];
            int b=lighthouse[i][1];
            arr[a].add(b);
            arr[b].add(a);
        }
        solve(1);
        //dp[i].on=i번 킨 경우, dp[i].off=i번 끈 경우
        answer=Math.min(dp[1].on,dp[1].off);
        return answer;
    }
    //킨 경우 = Math.min(이전 끈 경우+1)
    //끈 경우 = Math.min(이전 킨 경우)
        public static Node solve(int now){
            ch[now]=1;
            // If it is a leaf node
            if (arr[now].size() == 1 && ch[arr[now].get(0)] == 1) {
                dp[now].on = 1; // On case
                dp[now].off = 0; // Off case

                return dp[now];
            }
            // If already calculated
            if (dp[now].on != -1 && dp[now].off != -1) {

                return dp[now];
            }
            // Calculation
            int maxOn = 0;
            int maxOff = 0;
            for (int i = 0; i < arr[now].size(); i++) {
                int next = arr[now].get(i);
                if (ch[next] == 0) { // Proceed if not visited
                    ch[next]=1;
                    maxOff+=solve(next).on;
                    maxOn+= Math.min(dp[next].on,dp[next].off);
                }
            }
            dp[now].on = maxOn+1;
            dp[now].off = maxOff;

            return dp[now];
        }
    }
