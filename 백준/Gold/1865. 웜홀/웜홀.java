import java.util.*;
import java.io.*;
public class Main {
    //벨만 포드 알고리즘 이용
    static class Node{
        int n1;
        int n2;
        int dist;
        public Node(int n1,int n2,int dist){
            this.n1=n1;
            this.n2=n2;
            this.dist=dist;
        }
    }
    static int INF=999999999;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken()); //지점 갯수
            int m = Integer.parseInt(st.nextToken()); //도로 갯수
            int w = Integer.parseInt(st.nextToken()); //웜홀 갯수


            ArrayList<Node> nodes = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                nodes.add(new Node(n1, n2, d));
                nodes.add(new Node(n2, n1, d));
            }
            HashSet<Integer> set= new HashSet<>();
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(bf.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                nodes.add(new Node(n1, n2, (-1) * d));
                set.add(n1);
            }
            String ans = "NO";
            Iterator<Integer> itr=set.iterator();
            while(itr.hasNext()) {
                int i=itr.next();
                dist = new int[n + 1];
                for (int j = 1; j < n + 1; j++) {
                    dist[i] = INF;
                }
                if (bellman(nodes, n, i)) {
                    ans = "YES";
                    break;
                }
            }
            answer.append(ans+"\n");
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
    public static boolean bellman(ArrayList<Node> nodes,int n,int start){
        dist[start]=0;
        for(int i=1;i<n+1;i++){

            for(int j=0;j<nodes.size();j++){
                Node now=nodes.get(j);
                int n1=now.n1;
                int n2=now.n2;
                int d=now.dist;
                if(dist[n2]>dist[n1]+d){
                    dist[n2]=dist[n1]+d;
                    if(i==n){
                        return true;
                    }
                }
            }
            //마지막에 음의 사이클 발생하는지 확인 -> 있으면 true, 없으면 false
        }


        return false;
    }
}