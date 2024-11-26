import java.util.*;
import java.io.*;
public class Main {
    static String str1;
    static String str2;
    static int[][] lcs;
    static String answer="";
    static Stack<Character> stack=new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        str1=bf.readLine();
        str2=bf.readLine();
        lcs=new int[str1.length()+1][str2.length()+1];
        for(int i=1;i<str1.length()+1;i++){
            char c1=str1.charAt(i-1);
            for(int j=1;j<str2.length()+1;j++){
                char c2=str2.charAt(j-1);
                if(c1==c2){ //같으면 -> lcs[i-1][j-1]+1
                    lcs[i][j]=lcs[i-1][j-1]+1;
                }
                else{ //다르면 -> max(lcs[i][j-1],lcs[i-1][j])
                    lcs[i][j]=Math.max(lcs[i][j-1],lcs[i-1][j]);
                }
            }
        }
        solve(str1.length(),str2.length());
        while(!stack.isEmpty()){
            char s=stack.pop();
            answer+=s;
        }
        if(answer.equals("")){
            System.out.println(lcs[str1.length()][str2.length()]);
        }
        else {
            System.out.println(lcs[str1.length()][str2.length()] + "\n" + answer);
        }
    }
    public static void solve(int nowY,int nowX){
        if(lcs[nowY][nowX]==0){
            return ;
        }
        int nowNum=lcs[nowY][nowX];
        //위, 왼쪽 순
        if(nowNum==lcs[nowY-1][nowX]){
            solve(nowY-1,nowX);
        }
        else if(nowNum==lcs[nowY][nowX-1]){
            solve(nowY,nowX-1);
        }
        else{
//            System.out.println(str2.charAt(nowY-1));
            stack.add(str1.charAt(nowY-1));
            solve(nowY-1,nowX-1);
        }

    }
}