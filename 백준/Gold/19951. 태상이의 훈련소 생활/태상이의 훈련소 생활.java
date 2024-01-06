import java.util.*;
import java.io.*;

public class Main {
    static int N,M,h; //세그먼트 트리의 높이
    static int[] ground;
    static int[] segmentTree;
    static int[] answerIdx;
    static StringBuffer answer=new StringBuffer();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        h=baseLog(N,2);
        segmentTree=new int[(int)Math.pow(2,h+1)];
        ground=new int[N+1];
        answerIdx=new int[N+1];

        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            ground[i]=Integer.parseInt(st.nextToken());
        }

        makeSegment(1,1,N);

        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int left=Integer.parseInt(st.nextToken());
            int right=Integer.parseInt(st.nextToken());
            int diff=Integer.parseInt(st.nextToken());
            changeSegment(1,1,N,left,right,diff);
        }
        for(int i=1;i<N+1;i++){
            answer.append(query(1, 1, N, i, 0) + " ");

        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();

    }
    public static int query(int node, int s, int e, int idx, int ans) {
        if (e < idx || idx < s) return 0;
        ans += segmentTree[node];
        if (s == e) return ans;
        int mid = (s + e) / 2;
        return query(2 * node, s, mid, idx, ans) + query(2 * node + 1, mid + 1, e, idx, ans);
    }
//    public static void findAnswer(int nowIdx,int start,int end){
//
//        if(start==end){
//            answer.append(segmentTree[nowIdx]+" ");
//            return ;
//        }
//        findAnswer(nowIdx*2,start,(start+end)/2);
//        findAnswer(nowIdx*2+1,(start+end)/2+1,end);
//    }

    public static void makeSegment(int nowIdx,int start,int end){
        if(start==end){
            answerIdx[start]=nowIdx;
            segmentTree[nowIdx]=ground[start];
            return ;
//            return segmentTree[nowIdx]=ground[start];
        }

        makeSegment(2*nowIdx,start,(start+end)/2);
        makeSegment(2*nowIdx+1,(start+end)/2+1,end);
//        return segmentTree[nowIdx]=makeSegment(2*nowIdx,start,(start+end)/2) //왼쪽 자식
//                +makeSegment((2*nowIdx)+1,((start+end)/2)+1,end); //오른쪽 자식
    }

    public static void changeSegment(int nowIdx,int start,int end,int left,int right,int diff){
        //범위를 벗어나는 경우 -> 그냥 return
        if(right<start || left>end){
            return ;
        }

        //범위 안에 있는 경우 -> 해당 nowIdx에 diff값 저장
        if(left<=start && right>=end){
            segmentTree[nowIdx]+=diff;
            return ;
        }

        //해당 nowIdx가 리프노드가 아닌 경우 -> 해당 nowIdx의 왼쪽 자식, 오른쪽 자식들도 변경 해야됨
        changeSegment(nowIdx*2,start,(start+end)/2,left,right,diff ); //왼쪽 자식
        changeSegment(nowIdx*2+1,(start+end)/2+1,end,left,right,diff);

    }
    public static int baseLog(int x,int base){
        return (int)Math.ceil(Math.log(x)/Math.log(base));
    }
}