import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] num;
    static ArrayList<Integer> seq;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        num=new int[N];
        seq=new ArrayList<>();
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        seq.add(num[0]);
        for(int i=1;i<N;i++){
            if(seq.get(seq.size()-1)<num[i]){
                seq.add(num[i]);
            }
            else{
                int position=binarySearch(num[i]);
                seq.set(position,num[i]);
            }
        }
        System.out.println(seq.size());


    }
    public static int binarySearch(int target){
        int left=0;
        int right=seq.size();
        int Mid=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(seq.get(mid)>=target){ //왼쪽으로
                right=mid-1;
                Mid=mid;
            }
            else{
                left=mid+1;
            }
        }
        return Mid;
    }

}

/*

* */
