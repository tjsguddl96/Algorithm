import java.io.*;
import java.util.*;

public class Main {
    static int N,M,L,K; //가로, 세로
    static class Star implements Comparable<Star>{
        int x;
        int y;
        public Star(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Star o){
            int x=this.x-o.x;
            if(x==0){
                x=this.y-o.y;
            }
            return x;
        }
    }
    static ArrayList<Star> star=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=0;i<K;i++){
            st=new StringTokenizer(bf.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            star.add(new Star(x,y));
        }
        Collections.sort(star);
        int left=0;
        int right=0;
        int max=0;
        while(left<K){
            if(right==K){
                ArrayList<Integer> yList=new ArrayList<>();
                for(int i=left;i<right;i++){
                    yList.add(star.get(i).y);
                }
                Collections.sort(yList);
                int yLeft=0;
                int yRight=0;
                while(yLeft<yList.size()){
                    if(yRight==yList.size()){
                        max=Math.max(max,yRight-yLeft);
                        yLeft++;
                    }
                    else if(yList.get(yRight)-yList.get(yLeft)<=L){
                        yRight++;
                    }
                    else{
                        max=Math.max(max,yRight-yLeft);
                        yLeft++;
                    }
                }
                left++;
            }
            else if(star.get(right).x-star.get(left).x<=L){
                right++;
            }
            else{
                ArrayList<Integer> yList=new ArrayList<>();
                for(int i=left;i<right;i++){
                    yList.add(star.get(i).y);
                }
                Collections.sort(yList);
                int yLeft=0;
                int yRight=0;
                while(yLeft<yList.size()){
                    if(yRight==yList.size()){
                        max=Math.max(max,yRight-yLeft);
                        yLeft++;
                    }
                    else if(yList.get(yRight)-yList.get(yLeft)<=L){
                        yRight++;
                    }
                    else{
                        max=Math.max(max,yRight-yLeft);
                        yLeft++;
                    }
                }
                left++;
            }
        }
        System.out.println(K-max);
    }
}