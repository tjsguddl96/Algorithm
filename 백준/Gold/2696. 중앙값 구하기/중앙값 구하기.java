import java.util.*;
import java.io.*;
public class Main {
    static int T,M;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        T=Integer.parseInt(bf.readLine());

        for(int t=0;t<T;t++){
            M=Integer.parseInt(bf.readLine());
            int m=M/10+1;
            ArrayList<Integer> ans=new ArrayList<>();
            PriorityQueue<Integer> pq1=new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> pq2=new PriorityQueue<>();
            int mid=Integer.MAX_VALUE;
            int cnt=0;
            for(int i=0;i<m;i++){
                st=new StringTokenizer(bf.readLine());
                while(st.hasMoreTokens()){
                    int now=Integer.parseInt(st.nextToken());
                    cnt++;
                    if(mid==Integer.MAX_VALUE){
                        mid=now;
                        ans.add(mid);
                        continue;
                    }
                    if(now<mid){
                        pq1.add(now);
                    }
                    else{
                        pq2.add(now);
                    }
                    if(cnt%2==1) {
                        while (pq1.size() > pq2.size()) {
                            pq2.add(mid);
                            mid = pq1.poll();
                        }
                        while (pq2.size() > pq1.size()) {
                            pq1.add(mid);
                            mid = pq2.poll();
                        }
                        ans.add(mid);

                    }
                }
            }
            answer.append(ans.size()+"\n");
            for(int i=0;i<ans.size();i++){
                if(i>9 && i%10==0){
                    answer.append("\n");
                }
                answer.append(ans.get(i)+" ");
            }
            answer.append("\n");



        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();

    }
}
/*
3
9
1 2 3 4 5 6 7 8 9
9
9 8 7 6 5 4 3 2 1
23
23 41 13 22 -3 24 -31 -11 -8 -7
3 5 103 211 -311 -45 -67 -73 -81 -99
-33 24 56
* */