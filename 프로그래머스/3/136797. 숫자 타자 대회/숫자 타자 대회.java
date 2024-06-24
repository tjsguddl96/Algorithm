import java.util.*;
class Solution {
    static int[] dy={0,0,1,-1,-1,1,1,-1};
    static int[] dx={1,-1,0,0,-1,-1,1,1};
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static class Node implements Comparable<Node>{
        int y;
        int x;
        int d;
        public Node(int y,int x,int d){
            this.y=y;
            this.x=x;
            this.d=d;
        }
        @Override
        public int compareTo(Node o){
            return this.d-o.d;
        }
    }
    static int[][][] dp;
    static HashMap<Character,Position> map=new HashMap<>();
    static int[][] d=new int[13][13]; //* -> 10, 0->11, # -> 12
    static int[][] ch;
    static int start1=4;
    static int start2=6;
    public int solution(String numbers) {
        int answer = Integer.MAX_VALUE;
        dp=new int[numbers.length()][13][13];//[idx번호][왼손이 위치한 번호][오른손이 위치한 번호]
        for(int i=0;i<numbers.length();i++){
            for(int j=0;j<13;j++){
                for(int k=0;k<13;k++){
                    dp[i][j][k]=Integer.MAX_VALUE;
                }
            }
        }
        init();
        for(int i=1;i<13;i++){
            djkstra(i);
        }
        // System.out.println(d[11][1]+"!");
        // for(int i=1;i<10;i++){
        //     System.out.print(d[11][i]+" ");
        // }
        // System.out.println();
        // for(int i=1;i<10;i++){
        //     for(int j=1;j<10;j++){
        //         System.out.print(d[i][j]+" ");
        //     }
        //     System.out.println(d[i][11]);
        // }
        
        topDown(0,numbers,4,6);
        for(int i=0;i<13;i++){
            for(int j=0;j<13;j++){
                answer=Math.min(answer,dp[0][i][j]);
            }
        }
        return answer;
    }
    public static int topDown(int idx,String numbers,int left,int right){
        if(idx==numbers.length()){
            return 0;
        }
        if(dp[idx][left][right]==Integer.MAX_VALUE){
            int ans1=Integer.MAX_VALUE;
            int ans2=Integer.MAX_VALUE;
            int num=numbers.charAt(idx)-'0';
            if(num==0){
                num=11;
            }
            //왼손이 해당 번호에 위치하도록 왼손 움직이기
            if(right!=num){
                ans1=d[left][num]+topDown(idx+1,numbers,num,right);
            }
            //오른손이 해당 번호에 위치하도록 오른손 움직이기
            if(left!=num){
                ans2=d[right][num]+topDown(idx+1,numbers,left,num);
            }
            dp[idx][left][right]=Math.min(ans1,ans2);
        }
        
        return dp[idx][left][right];
        
    }
    
    public static void djkstra(int start){
        Position startP;
        char key;
        if(start==10){
            key='*';
        }
        else if(start==11){
            key='0';
        }
        else if(start==12){
            key='#';
        }
        else{
            key=Integer.toString(start).charAt(0);
        }
        startP=map.get(key);
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(startP.y,startP.x,0));
        ch=new int[4][3];
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                ch[i][j]=Integer.MAX_VALUE;
            }
        }
        ch[startP.y][startP.x]=1;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowD=now.d;
            for(int i=0;i<8;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                int cost;
                if(i<4){
                    cost=2;
                }
                else{
                    cost=3;
                }
                if(isIn(nextY,nextX) && ch[nextY][nextX]>cost+nowD){
                    ch[nextY][nextX]=cost+nowD;
                    pq.add(new Node(nextY,nextX,ch[nextY][nextX]));
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(i==startP.y && j==startP.x){
                    d[start][start]=1;
                    continue;
                }
                int number=i*3+j+1;
                d[start][number]=ch[i][j];
            }
        }
    }
    public static boolean isIn(int y,int x){
        if(y>=0 && y<4 && x>=0 && x<3){
            return true;
        }
        return false;
    }
    public static void init(){
        for(int i=1;i<10;i++){
            int y=i/3;
            int x=i%3-1;
            if(i%3==0){
                x=2;
                y--;
            }
            map.put(Integer.toString(i).charAt(0),new Position(y,x));
        }
        map.put('*',new Position(3,0));
        map.put('0',new Position(3,1));
        map.put('#',new Position(3,2));
        for(int i=1;i<13;i++){
            for(int j=1;j<13;j++){
                d[i][j]=Integer.MAX_VALUE;
            }
        }
    }
}