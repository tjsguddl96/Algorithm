import java.util.*;
import java.io.*;
public class Main {
    static int N,M,R;
    static int[] positions;
    static ArrayList<Integer> widths=new ArrayList<>();
    static int[] lengths;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        positions=new int[N];
        lengths=new int[M];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            positions[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(positions);
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<M;i++){
            lengths[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                widths.add(Math.abs(positions[j]-positions[i]));
            }
        }
        Collections.sort(widths);
        int left=0;
        int right=widths.size()-1;
        double answer=-1;
        for(int i=0;i<M;i++){
            int nowH=lengths[i];
            left=0;
            right=widths.size()-1;
            while(left<=right){
                int mid=(left+right)/2;
                double nowR=(double)widths.get(mid)*(double)nowH*(0.5);
                if(nowR<=R){
                    answer=Math.max(answer,nowR);
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        if(answer==-1){
            System.out.println(-1);
        }
        else {
            System.out.println(String.format("%.1f",answer));
        }



    }

}
/*
2 1 1000000000
-20000 20000
40000
correct answer 800000000.0
wrong answer 8.0E8

3 5 23
-5 -7 5
1 6 2 8 10

2 1 190
-1 -20
20
* */