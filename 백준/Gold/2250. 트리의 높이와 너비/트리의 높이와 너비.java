import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] tree;
    static int w=1;
    static int width[];
    static int h[];
    static int hh=0;
    static int[][] hw;

    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());

        tree=new int[n+1][2];
        width=new int[n+1];
        h=new int[n+1];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,1);
        }
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(bf.readLine());
            int node=Integer.parseInt(st.nextToken());
            int left=Integer.parseInt(st.nextToken());
            int right=Integer.parseInt(st.nextToken());
            if(map.get(left)!=null){
                map.remove(left);
            }
            if(map.get(right)!=null){
                map.remove(right);
            }
            tree[node][0]=left;
            tree[node][1]=right;
        }
        int root=0;
        for(Integer key:map.keySet()){
            root=key;
            break;
        }
        inorder(root,1);
        hw=new int[hh+1][2];//hw[높이][0]=w의 최소, hw[높이][1]=w의 최대
        for(int i=1;i<=hh;i++){
            hw[i][0]=Integer.MAX_VALUE;
        }
        for(int i=1;i<=n;i++){
            int nowW=width[i];
            int nowH=h[i];
//            System.out.println(i+" 행 : "+ nowH+" 열 : "+nowW);
            hw[nowH][0]=Math.min(hw[nowH][0],nowW);
            hw[nowH][1]=Math.max(hw[nowH][1],nowW);
        }
        int ans=0;
        int ansh=0;
        for(int i=1;i<=hh;i++){
            int tmp=hw[i][1]-hw[i][0]+1;
            if(tmp>ans){
                ans=tmp;
                ansh=i;
            }
        }
        System.out.println(ansh+" "+ans);

    }
    public static void inorder(int node,int height){
        if(node==-1) {
            return;
        }
        int left=tree[node][0];
        inorder(left,height+1);
        width[node]=w;
        h[node]=height;
        hh=Math.max(hh,height);
        w++;
        int right=tree[node][1];
        inorder(right,height+1);

    }
}