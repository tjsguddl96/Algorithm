import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] weight=new int[5][5];
	static ArrayList<Integer> arr;
	static int size=0;
	static int[][][] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		arr=new ArrayList<>();
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		while(st.hasMoreTokens()) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		size=arr.size()-1;
		ans=new int[size][5][5];
		
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(i==0 || j==0) {
					weight[i][j]=2;
				}
				else if(i==j) {
					weight[i][j]=1;
				}else if(Math.abs(i-j)==2) {
					weight[i][j]=4;
				}else {
					weight[i][j]=3;
				}
			}
		}
		int ans=dfs(0,0,0);
		System.out.println(ans);
		
	}
	//ans[depth][left][right] 
	public static int dfs(int depth,int left,int right) {
		if(depth==size) {
			return 0;
		}
		if(ans[depth][left][right]!=0) {
			return ans[depth][left][right];
		}
		
		ans[depth][left][right]=Math.min(dfs(depth+1,arr.get(depth),right)+weight[left][arr.get(depth)], dfs(depth+1,left,arr.get(depth))+weight[right][arr.get(depth)]);
		return ans[depth][left][right];
	}

}