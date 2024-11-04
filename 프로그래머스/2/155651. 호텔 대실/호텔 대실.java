import java.util.*;
class Solution {
    static int[] arr;
    static int[] sum;
    public int solution(String[][] book_time) {
        int answer = 0;
        arr=new int[1451];
        sum=new int[1451];
        for(int i=0;i<book_time.length;i++){
            int startTime=calTime(book_time[i][0]);
            int endTime=calTime(book_time[i][1])+10;
            arr[startTime]+=1;
            arr[endTime]+=(-1);
        }
        sum[0]=arr[0];
        for(int i=1;i<1451;i++){
            sum[i]=sum[i-1]+arr[i];
            answer=Math.max(sum[i],answer);
        }
        return answer;
    }
    public static int calTime(String time){
        String[] tmp=time.split(":");
        int h=Integer.parseInt(tmp[0])*60;
        int m=Integer.parseInt(tmp[1]);
        return h+m;
    }
}