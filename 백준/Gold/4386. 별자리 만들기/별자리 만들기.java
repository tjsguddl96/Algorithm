import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static class Star{
        double x;
        double y;
        public Star(double x,double y){
            this.x=x;
            this.y=y;
        }
    }
    static class Dist implements Comparable<Dist>{
        double dist;
        int star1;
        int star2;
        public Dist(double dist,int star1,int star2){
            this.dist=dist;
            this.star1=star1;
            this.star2=star2;
        }
        @Override
        public int compareTo(Dist o){
            double x=this.dist-o.dist;
            if(x>0){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
    static Star[] stars;
    static int[] parent;
    static PriorityQueue<Dist> d=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        stars=new Star[n];
        parent=new int[n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            double x=Double.parseDouble(st.nextToken());
            double y=Double.parseDouble(st.nextToken());
            stars[i]=new Star(x,y);
            parent[i]=i;
        }
        for(int i=0;i<stars.length;i++){
            for(int j=i+1;j<stars.length;j++){
                d.add(new Dist(getDistance(stars[i],stars[j]),i,j));
            }
        }
        double answer=0;
        while(!d.isEmpty()){
            Dist now=d.poll();
            int star1=now.star1;
            int star2=now.star2;
            double dist=now.dist;
            if(findParent(star1)!=findParent(star2)){
                union(star1,star2);
                answer+=dist;
            }

        }
        System.out.println(String.format("%.2f",answer));
    }

    public static int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return findParent(parent[x]);
    }
    public static void union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);
        if(parentA==parentB){
            return ;
        }
        else if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }

    public static double getDistance(Star a,Star b){
        double X=Math.pow((a.x-b.x),2);
        double Y=Math.pow((a.y-b.y),2);
        return Math.sqrt(X+Y);
    }
}