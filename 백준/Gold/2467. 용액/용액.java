import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] answer;
	static ArrayList<Integer> posi;
	static ArrayList<Integer> nega;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(bf.readLine());
		
		answer=new int[2];
		posi=new ArrayList<>();
		nega=new ArrayList<>();
		
		ans=Integer.MAX_VALUE;
		StringTokenizer st=new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			int a=Integer.parseInt(st.nextToken());
			if(a>=0) {
				posi.add(a);
			}else {
				nega.add(a);
			}
		}
		for(int i=0;i<nega.size();i++) {
			binary(nega.get(i));
		}
		if(nega.size()>=2) {
			int size=nega.size();
			int tmp=Math.abs(nega.get(size-1)+nega.get(size-2));
			if(tmp<ans) {
				ans=tmp;
				answer[0]=nega.get(size-1);
				answer[1]=nega.get(size-2);
			}
		}
		if(posi.size()>=2) {
			int tmp=posi.get(0)+posi.get(1);
			if(tmp<ans) {
				ans=tmp;
				answer[0]=posi.get(0);
				answer[1]=posi.get(1);
			}
		}
		Arrays.sort(answer);
		System.out.println(answer[0]+" "+answer[1]);
	}
	public static void binary(int target) {
		int left=0;
		int right=posi.size()-1;
		while(left<=right) {
			int mid=(left+right)/2;
			int tmp=target+posi.get(mid);
			if(ans>Math.abs(tmp)) {
				ans=Math.abs(tmp);
				answer[0]=target;
				answer[1]=posi.get(mid);
			}
			if(tmp<=0) {
				left=mid+1;
			}
			else {
				right=mid-1;
			}
			
		}
		
	}
}