import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static ArrayList<Integer> positive=new ArrayList<>();
    static ArrayList<Integer> negative=new ArrayList<>();
    static int[] answer=new int[2];
    static int ans=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++){
            int n=Integer.parseInt(st.nextToken());
            if(n<0){
                negative.add(n);
            }
            else{
                positive.add(n);
            }
        }


        for(int i=0;i<negative.size();i++){
            binary(negative.get(i));
        }

        if(positive.size()>=2){
            if(ans> positive.get(0)+ positive.get(1)){
                ans=positive.get(0)+positive.get(1);
                answer[0]=positive.get(0);
                answer[1]=positive.get(1);
            }

        }
        if(negative.size()>=2){
            int s=negative.size();
            if(ans> Math.abs(negative.get(s-2)+ negative.get(s-1))){
                answer[0]= negative.get(s-2);
                answer[1]= negative.get(s-1);
            }
        }
        Arrays.sort(answer);
        System.out.println(answer[0]+" "+answer[1]);

    }
    public static void binary(int target){
        int left=0;
        int right=positive.size()-1;
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            int tmp=target+positive.get(mid);
            if(ans>Math.abs(tmp)){
                ans=Math.abs(tmp);
                answer[0]=target;
                answer[1]=positive.get(mid);
            }
            if(tmp<=0){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
    }
}
/*
4
-1 1 2 3

5
-2 -1 1 2 3

4
-100 1 2 3

4
-3 -2 -1 100
* */