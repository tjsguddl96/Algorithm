import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static ArrayList<Integer> dp;
    static int answer=1;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        dp=new ArrayList<>();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(st.nextToken());
            if(dp.isEmpty()){
                dp.add(num);
            }
            else{
                int size=dp.size();
                if(num>dp.get(size-1)){
                    dp.add(num);
                }
                else{
                    int idx=binarySearch(num);
                    dp.set(idx,num);
                }

            }
        }
        System.out.println(dp.size());
    }
    public static int binarySearch(int target){
        int left=0;
        int right=dp.size()-1;
        int Mid=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(dp.get(mid)<target){
                left=mid+1;
            }
            else{
                right=mid-1;
                Mid=mid;
            }
        }
        return Mid;
    }
}