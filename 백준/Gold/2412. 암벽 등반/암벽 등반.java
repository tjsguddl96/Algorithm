import java.util.*;
import java.io.*;

public class Main {
    static class Hom{
        int x;
        int y;
        int idxX;
        int dist;
        public Hom(int x,int y,int idxX,int dist){
            this.x=x;
            this.y=y;
            this.idxX=idxX;
            this.dist=dist;
        }
    }
    static int n,T;
    static int[][] ch;
    static int max;
    static ArrayList<Integer>[] homs=new ArrayList[200001];
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());
        for(int i=0;i<200001;i++){
            homs[i]=new ArrayList<>();
        }
        homs[0].add(0);
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            homs[y].add(x);
        }
        for(int i=0;i<200001;i++){
            Collections.sort(homs[i]);
            max=Math.max(max,homs[i].size());
        }
        ch=new int[200001][max];
        ArrayDeque<Hom> q=new ArrayDeque<>();
        q.add(new Hom(0,0,0,0));
        ch[0][0]=1;
        int answer=-1;
        while(!q.isEmpty()){
            Hom now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowD=now.dist;
            int nowIdxX=now.idxX;
//            System.out.println(nowX+" "+nowY+" "+nowD);
            if(nowY==T){
                answer=nowD;
                break;
            }
            for(int i=nowY-2;i<=nowY+2;i++){
                if(i<0 || i>=200001){
                    continue;
                }
                int nextY=i;
                for(int j=0;j<homs[nextY].size();j++){
                    int nextX=homs[nextY].get(j);
                    if(nextX>(nowX+2)){
                        break;
                    }
                    else if(nextX<(nowX-2)){
                        continue;
                    }
                    else{
                        if(ch[nextY][j]==0) {
                            ch[nextY][j]=1;
                            q.add(new Hom(nextX, nextY,j,nowD+1));
                        }
                    }
                }
            }
        }
        System.out.println(answer);



    }
}