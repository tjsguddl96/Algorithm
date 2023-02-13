import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Queue<Integer> q=new ArrayDeque<>();
		ArrayList<Integer> ans=new ArrayList<>();
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			q.offer(i+1);
		}
		
		while(ans.size()<n) {
			for(int i=0;i<k-1;i++) {
				q.offer(q.poll());
			}
			ans.add(q.poll());
		}
		System.out.print("<");
		for(int i=0;i<n;i++) {
			if (i==n-1) {
				System.out.print(ans.get(i));
			}
			else {
				System.out.print(ans.get(i)+", ");
			}
		}
		System.out.print(">");
	}

}