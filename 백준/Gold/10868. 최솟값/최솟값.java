import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] nums;
    static long[] segments;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        nums=new int[N+1];
        double tmp=Math.log(N)/Math.log(2);
        int tmp2=(int)tmp;
        int h;
        if(Math.pow(2,tmp2)==N){
            h=tmp2;
        }
        else{
            h=tmp2+1;
        }
        int segSize=(int)Math.pow(2,h+1);
        segments=new long[segSize+2];
        for(int i=1;i<N+1;i++){
            nums[i]=Integer.parseInt(bf.readLine());
        }
        makeSeg(1,1,N);
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            answer.append(findSeg(1,a,b,1,N)+"\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
    public static void makeSeg(int segIndex,int left,int right){
        if(left==right){
            segments[segIndex]=nums[left];
            return ;
        }
        int mid=(left+right)/2;
        makeSeg(segIndex*2,left,mid);
        makeSeg(segIndex*2+1,mid+1,right);
        segments[segIndex]=Math.min(segments[segIndex*2],segments[segIndex*2+1]);
    }
    public static long findSeg(int segIndex,int left,int right,int start,int end){
        if(left>end || right<start){
            return Long.MAX_VALUE;
        }
        if(left<=start && end<=right){
            return segments[segIndex];
        }
        int mid=(start+end)/2;
        long lMin=findSeg(2*segIndex,left,right,start,mid);
        long rMin=findSeg(2*segIndex+1,left,right,mid+1,end);
        return Math.min(lMin,rMin);
    }
}