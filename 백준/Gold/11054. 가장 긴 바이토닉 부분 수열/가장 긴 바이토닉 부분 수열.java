import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] arr;
    static int[] arr2;
    static ArrayList<Integer> lis=new ArrayList<>();
    static ArrayList<Integer> lis2=new ArrayList<>();
    static int[] dp1;
    static int[] dp2;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        arr=new int[N+1];
        arr2=new int[N+1];
        dp1=new int[N+1];
        dp2=new int[N+1];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            arr2[N+1-i]=arr[i];
        }
        for(int i=1;i<N+1;i++){
            if(lis2.size()==0){
                lis2.add(arr2[i]);
                dp2[i]=lis2.size();
            }
            else{
                if (lis2.get(lis2.size() - 1) < arr2[i]) {
                    lis2.add(arr2[i]);
                    dp2[i] = lis2.size();
                }
                else {
                    int pos = binarySearch(arr2[i],lis2);
                    lis2.set(pos, arr2[i]);
                    dp2[i]=pos+1;
                }

            }
            if(lis.size()==0){
                lis.add(arr[i]);
                dp1[i]=lis.size();
            }
            else {
                if (lis.get(lis.size() - 1) < arr[i]) {
                    lis.add(arr[i]);
                    dp1[i] = lis.size();
                }
                else {
                    int pos = binarySearch(arr[i],lis);
                    lis.set(pos, arr[i]);
                    dp1[i]=pos+1;
                }
            }

        }
        int answer=0;
        for(int i=1;i<N+1;i++){
            answer=Math.max(answer,dp1[i]+dp2[N+1-i]-1);
        }
        System.out.println(answer);
    }
    public static int binarySearch(int target,ArrayList<Integer> lis){
        int left=0;
        int right=lis.size()-1;
        int mid=0;
        int MID=0;
        while(left<=right){
            mid=(left+right)/2;
            if(lis.get(mid)<target){
                left=mid+1;
            }
            else{
                MID=mid;
                right=mid-1;
            }
        }
        return MID;
    }

}