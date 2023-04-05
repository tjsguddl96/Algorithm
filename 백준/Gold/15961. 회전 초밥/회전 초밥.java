import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Integer,Integer> hm=new HashMap<>();
	public static void main(String[] args) throws IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int n,d,k,c; //접시 수, 가짓수, 연속해서 먹는 접시 수, 쿠폰 번호
		n=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		Queue<Integer> q=new ArrayDeque<>();
		
		
		
		
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(bf.readLine());
			if(i<k) {
				if(hm.get(arr[i])==null) {
					hm.put(arr[i], 1);
				}else {
					int tmp=hm.get(arr[i]);
					hm.put(arr[i],tmp+1);
				}
				q.add(arr[i]);
			}
		}
		
		
		int p1=0;
		int flag=0;
		int p2=k-1;
		int ans=0;
		if(hm.get(c)==null) {
			ans=Math.max(ans, hm.size()+1);
		}else {
			ans=Math.max(ans, hm.size());
		}
		
		while(p1<n) {
			flag=1;
			p1++;
			int frontKey=q.poll();
			int frontVal=hm.get(frontKey);
			if(frontVal==1) {
				hm.remove(frontKey);
			}else {
				hm.put(frontKey, frontVal-1);
			}
			p2=(p2+1)%n;
			q.add(arr[p2]);
			if(hm.get(arr[p2])==null) {
				hm.put(arr[p2], 1);
			}else {
				int addedVal=hm.get(arr[p2]);
				hm.put(arr[p2], addedVal+1);
			}
			if(hm.get(c)==null) {
				ans=Math.max(ans, hm.size()+1);
			}else {
				ans=Math.max(ans, hm.size());
			}
			
			
		}

		System.out.println(ans);
		
	}
	public static void print() {
		for(Integer i:hm.keySet()) {
			System.out.println(i+" : "+hm.get(i));
		}
		System.out.println("--------------------");
	}

}