import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] crain;
    static int[] box;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        crain=new int[N];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            crain[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crain);
        M=Integer.parseInt(bf.readLine());
        box=new int[M];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<M;i++){
            box[i]=Integer.parseInt(st.nextToken()); // 홍몽 :)
        }
        Arrays.sort(box);
        int left=0;
        int right=Integer.MAX_VALUE;
        int Mid=0;
        int mid=0;
        if(crain[N-1]<box[M-1]){
            System.out.println(-1);
        }
        else {
            while (left <= right) {
                mid = (left + right) / 2;
                int boxIdx = 0;
                int crainIdx = 0;
                int cnt = 0;
                while (crainIdx < N && boxIdx < M) {
                    if (cnt < mid && crain[crainIdx] >= box[boxIdx]) {
                        cnt++;
                        boxIdx++;
                    } else {
                        cnt = 0;
                        crainIdx++;
                    }
                }
                if (boxIdx >= M) {
                    Mid = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(Mid);

        }
    }
}
/*
1
6
3
2 2 8
* */