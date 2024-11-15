import java.util.*;

class Solution {
    static int destination;
    static int max;
    static int[] parent;
    static class Node implements Comparable<Node>{
        int n1;
        int n2;
        int d;
        public Node(int n1,int n2,int d){
            this.n1=n1;
            this.n2=n2;
            this.d=d;
        }
        @Override
        public int compareTo(Node o){
            int x=this.d-o.d;
            if(x==0){
                x=this.n2-o.n2;
            }
            return x;
        }
    }
    static class Ans implements Comparable<Ans>{
        int n;
        int d;
        public Ans(int n,int d){
            this.n=n;
            this.d=d;
        }
        @Override
        public int compareTo(Ans o){
            int x=this.d-o.d;
            if(x==0){
                x=this.n-o.n;
            }
            return x;
        }
        
    }
    static ArrayList<Node>[] arr;
    static HashSet<Integer> set1=new HashSet<>();
    static HashSet<Integer> set2=new HashSet<>();
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static PriorityQueue<Ans> ans=new PriorityQueue<>();
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        for(int i=0;i<summits.length;i++){
            set1.add(summits[i]);
        }
        for(int i=0;i<gates.length;i++){
            set2.add(gates[i]);
        }
        arr=new ArrayList[n+1];
        parent=new int[n+1];
        for(int i=0;i<n+1;i++){
            arr[i]=new ArrayList<>();
            parent[i]=i;
        }
        for(int i=0;i<paths.length;i++){
            int n1=paths[i][0];
            int n2=paths[i][1];
            int d=paths[i][2];
            //summit은 무조건 n2로. 둘다 summit인 경우도 고려
            if(set1.contains(n1)){
                if(set1.contains(n2)){ //둘다 summit인 경우
                    pq.add(new Node(Math.max(n1,n2),Math.min(n1,n2),d));
                }
                else{
                    pq.add(new Node(n2,n1,d));
                }
            }
            else{ //n1이 summit이 아님 -> n2가 summit이거나 둘다 summit이 아니거나
                pq.add(new Node(n1,n2,d));
            }
        }
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int n1=now.n1;
            int n2=now.n2;
            int d=now.d;
            int parentN1=getParent(n1);
            int parentN2=getParent(n2);
            if(parentN1!=parentN2){
                max=Math.max(max,d);
                union(n1,n2);
                
                // if(is(parentN1,parentN2)==2 ||is(parentN1,parentN2)==4){
                //     break;
                // }
            }
            
        }
        
        answer[0]=ans.peek().n;
        answer[1]=ans.peek().d;
        return answer;
    }
    public static int getParent(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=getParent(parent[x]);
    }
    public static void union(int a,int b){
        int parentA=getParent(a);
        int parentB=getParent(b);
        int flag=is(parentA,parentB);
        if(flag==1 || flag==5){
            return ;   
        }
        else if(flag==2){ //parentA가 summit, parentB가 gate -> 답 갱신
            // destination=parentA;
            ans.add(new Ans(parentA,max));
        }
        else if(flag==3 || flag==6){//parentA가 summit => parentB의 parent를 parentA로
            parent[parentB]=parentA;
        }
        else if(flag==4){//parentA가 gate, parentB가 summit -> 답 갱신
            // destination=parentB;
            ans.add(new Ans(parentB,max));
            
        }
        else if(flag==7 || flag==8){
            parent[parentA]=parentB;
        }
        else{ //둘다 그냥 쉼터
            if(parentA<parentB){
                parent[parentB]=parentA;
            }
            else{
                parent[parentA]=parentB;
            }
        }
    }
    //set1=>summits, set2=>gates
    public static int is(int a,int b){
        if(set1.contains(a)){
            if(set1.contains(b)){
                return 1;
            }
            else if(set2.contains(b)){
                return 2;
            }
            else{
                return 3;
            }
        }
        else if(set2.contains(a)){
            if(set1.contains(b)){
                return 4;
            }
            else if(set2.contains(b)){
                return 5;
            }
            else{
                return 6;
            }
        }
        else{
            if(set1.contains(b)){
                return 7;
            }
            else if(set2.contains(b)){
                return 8;
            }
            else{
                return 9;
            }
        }
    }
}