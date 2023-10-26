import java.util.*;
import java.io.*;
public class Main {
    static int n; //식재료 갯수
    static int[][] m;
    static int minC=999999999;
    static Stack<Integer> result=new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        m=new int[n+1][5]; //[][0] : mp, [][1] : mf, [][2] : ms, [][3] : mv, [][4] : 돈

        StringTokenizer st;


        for(int i=0;i<=n;i++){ //m[0][j] : 꼭 섭취해야하는 최저 영양소
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                if(i==0 && j==4){
                    break;
                }
                m[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<n+1;i++) {
            Stack<Integer> stack = new Stack<>();
            stack.add(i);

            cal(i, m[i][0], m[i][1], m[i][2], m[i][3], m[i][4], stack);
        }
        if(minC==999999999){
            System.out.println(-1);
        }else {
            System.out.println(minC);
            while(!result.isEmpty()){
                System.out.print(result.pop()+" ");
            }
        }
    }
    public static void cal(int idx,int sumMp,int sumMf,int sumMs,int sumMv,int sumC,Stack<Integer> stack){ //m[idx][]
        if(sumMp>=m[0][0] && sumMf>=m[0][1] && sumMs>=m[0][2] && sumMv>=m[0][3]){
            if(sumC<minC){
                minC=sumC;
                Stack<Integer> tmp=new Stack<>();
                result=new Stack<>();
                while(!stack.isEmpty()){
                    int now=stack.pop();
                    tmp.add(now);
                    result.add(now);
                }
                while(!tmp.isEmpty()){
                    stack.add(tmp.pop());
                }
            }
            return ;
        }
        for(int i=idx+1;i<n+1;i++){
            stack.add(i);
            cal(i,sumMp+m[i][0],sumMf+m[i][1],sumMs+m[i][2],sumMv+m[i][3],sumC+m[i][4],stack);
            stack.pop();
        }

    }
}