import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {

	static int N;
    static int[][] paper;
    static boolean[][] board;
    public static void main(String[] args) throws IOException {
    	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    	board=new boolean[101][101];
    	int answer=0;
    	N=Integer.parseInt(bf.readLine());
    	for(int i=0;i<N;i++) {
    		StringTokenizer st=new StringTokenizer(bf.readLine());
    		int x=Integer.parseInt(st.nextToken());
    		int y=Integer.parseInt(st.nextToken());
    		for(int j=x;j<x+10;j++) {
    			for(int k=y;k<y+10;k++) {
    				if(board[j][k]==false) {
    					board[j][k]=true;
    					answer++;
    				}
    			}
    		}
    	}
    	System.out.println(answer);
    	
    }
}
