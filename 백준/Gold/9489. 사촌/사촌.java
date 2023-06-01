import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(n==0 && k==0){
                break;
            }

            int[] list=new int[n];
            st=new StringTokenizer(bf.readLine());
            for(int i=0;i<n;i++){
                list[i]=Integer.parseInt(st.nextToken());
            }
            if(n<2){
                System.out.println(0);
                continue;
            }
            int nowParentIdx=0;

            ArrayList<Integer> parent[]=new ArrayList[1000];
            parent[0]=new ArrayList<>();
            int KparentIdx=0;
            int previous=list[1];


            for(int i=1;i<n;i++){
                int now=list[i];
                if(now-previous>1){
                    nowParentIdx++;
                    parent[nowParentIdx]=new ArrayList<>();
                }
                parent[nowParentIdx].add(i);
                previous=now;
                if(now==k){
                    KparentIdx=nowParentIdx;
                }
            }

            System.out.println(findCousin(KparentIdx,list,parent));
        }
    }
    public static int findCousin(int KparentIdx,int[] list,ArrayList<Integer> parent[]){
        int cousinSum=0;
        int grandIdx=-1;
        for(int i=KparentIdx-1;i>=0;i--){
            for(int j=0;j<parent[i].size();j++){
                if(parent[i].get(j)==KparentIdx){
                    grandIdx=i;
                    break;
                }
            }
        }
        if(grandIdx==-1){
            return 0;
        }
        for(int i=0;i<parent[grandIdx].size();i++){
            if(parent[grandIdx].get(i)==KparentIdx || parent[parent[grandIdx].get(i)]==null){
                continue;
            }
            cousinSum+=parent[parent[grandIdx].get(i)].size();
        }

        return cousinSum;
    }
}
/*
19 1000
7 10 11 12 13 15 17 18 22 700 800 900 1000 2000 4000 10001 10002 10004 30000
0 0

10 32
1 3 4 5 8 9 15 30 31 32
 */