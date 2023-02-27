import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int n,m,T;
	static int[] parents;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(bf.readLine());
		for(int tc=1;tc<=T;tc++){
			StringTokenizer st=new StringTokenizer(bf.readLine());
			
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			arr=new int[m][2];
			parents=new int[n+1];
			for(int i=0;i<m;i++) {
				StringTokenizer st1=new StringTokenizer(bf.readLine());
				
				int n1=Integer.parseInt(st1.nextToken());
				int n2=Integer.parseInt(st1.nextToken());
				arr[i][1]=n2;
				arr[i][0]=n1;
			}
			
			Arrays.sort(arr,(o1,o2)->{
				return o1[0]-o2[0];
			});

			for(int i=1;i<=n;i++) {
				parents[i]=i;
			}
			for(int i=0;i<m;i++) {
				union(find(arr[i][0]),find(arr[i][1]));
				
			}
			for(int i=0;i<m;i++) {
				union(parents[arr[i][0]],parents[arr[i][1]]);
				
			}
			Set<Integer> set=new HashSet<>();
			for(int i=1;i<=n;i++) {
				set.add(find(i));
			}
			System.out.println("#"+tc+" "+set.size());
			
		}
		
		
	}
	private static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return find(parents[a]);
		
	}
	private static void union(int a,int b) {
		int parentA=find(a);
		int parentB=find(b);
		
		if(parentA<=parentB) {
			parents[b]=parentA;
		}
		else {
			parents[a]=parentB;
		}
		
	}

}
/*
1
3 2
3 2
2 1

1
7 3
1 3
3 4
6 6

1
6 6
1
2
3
4
5
6

1
7 5
1 3
3 4
6
6 7
4 6
 * */