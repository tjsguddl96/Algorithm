import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] edges;
    static class Edge{
        int n1;
        int n2;
        public Edge(int n1,int n2){
            this.n1=n1;
            this.n2=n2;
        }
    }
    static long cntD,cntG;
    static ArrayList<Edge> edgeList=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        edges=new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            edges[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            edges[n1].add(n2);
            edges[n2].add(n1);
            edgeList.add(new Edge(n1,n2));
        }
        for(int i=1;i<N+1;i++){
            if(edges[i].size()>=3){
                long cnt=edges[i].size();
                cntG+=(cnt*(cnt-1)*(cnt-2)/6);
            }
        }
        for(int i=0;i<edgeList.size();i++){
            int n1=edgeList.get(i).n1;
            int n2=edgeList.get(i).n2;
            cntD+=(edges[n1].size()-1)*(edges[n2].size()-1);
        }

        if(cntD==cntG*3){
            answer.append("DUDUDUNGA");
        }
        else if(cntD>cntG*3){
            answer.append("D");
        }
        else{
            answer.append("G");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();

    }

}
/*
10
10 9
8 9
5 8
1 2
4 3
3 7
3 5
3 6
2 3
* */