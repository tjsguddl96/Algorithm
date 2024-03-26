import java.util.*;

public class Main {
	static int C[][] = new int[5][1000];
	static int t, n, k, result, sub;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		t = sc.nextInt();
		for(int i = 0 ; i < t ; i++)
			System.out.println(B());
 	}
	
	static public int B() {
		result = sub = Integer.MAX_VALUE;
		k = sc.nextInt();
		n = sc.nextInt();
		ArrayList<Integer> C_12 = new ArrayList<Integer>(n*n);
		ArrayList<Integer> C_34 = new ArrayList<Integer>(n*n);
		
		for(int i = 1 ; i <= 4; i++) {
			for(int j = 0 ; j < n ; j++) {
				C[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				C_12.add(C[1][i]+C[2][j]);
				C_34.add(C[3][i]+C[4][j]);
			}
		}
		
		C_34.sort(null);
				
		for(int i = 0 ; i < n * n; i++) {
			int l = n * n - 1;
			int f = 0;
			int diff, m, sum;
			while(l >= f) {
				m = (l + f) / 2;
				sum = C_12.get(i) + C_34.get(m);
				diff = Math.abs(sum - k);
				
				if(sum == k) return sum;
				else if(sum < k) f = m + 1;
				else l = m - 1;
				
				if(diff < sub) {
					result = sum;
					sub = diff;
				} else if(diff == sub) {
					result = Math.min(result, sum);
				}
			}
		}
		return result;
	}
}