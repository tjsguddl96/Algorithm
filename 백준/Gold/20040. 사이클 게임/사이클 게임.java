import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int parent[];
    static int ans;
    static int input[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        parent=new int[n];
        input=new int[m][2];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            input[i][0]=n1;
            input[i][1]=n2;
        }
        for(int i=0;i<m;i++){
            int n1=0;
            int n2=0;
            for(int j=0;j<2;j++){
                n1=input[i][0];
                n2=input[i][1];
            }
            if(union(n1,n2)){
                ans=i+1;
                break;
            }
        }
        System.out.println(ans);

    }
    public static int findParent(int node){
        if(node==parent[node]) {
            return node;
        }
        return findParent(parent[node]);
    }

    public static boolean union(int n1,int n2){
        int p1=findParent(n1);
        int p2=findParent(n2);
        if(p1!=p2){ //싸이클이 아닐때 (부모가 다름)
            if(p1>p2){ //작은애로 부모.
                parent[p1]=p2;
            }else{
                parent[p2]=p1;
            }
            return false;
        }else{
            return true; //싸이클이 생기면 true 반환
        }
    }
}