import java.io.*;
import java.util.*;
public class Main {
    static int A;
    static int[] arr;
    static ArrayList<Integer> seq=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder answer=new StringBuilder();

        A=Integer.parseInt(bf.readLine());

        StringTokenizer st=new StringTokenizer(bf.readLine());

        arr=new int[A];
        for(int i=0;i<A;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        seq.add(arr[0]);

        for(int i=1;i<A;i++){
            int now=arr[i];
            if(seq.get(seq.size()-1)<now){
                seq.add(now);
            }
            else{
                int pos=binarySearch(now);
                seq.set(pos,now);
            }
        }
        System.out.println(seq.size());

    }
    static public int binarySearch(int target){
        int left=0;
        int right=seq.size()-1;
        int Mid=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(seq.get(mid)>=target){
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
10
1 1 1 1 1 1 1 1 1 1
->1

5
1 1 2 2 1
->2


5
1 2 3 4 5
->5

5
1 2 5 3 4
->4

6
5 4 3 3 3 1
->1
*/
