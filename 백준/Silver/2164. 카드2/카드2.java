import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> q=new ArrayDeque<>();
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}
		
		while(q.size()>1) {
			q.poll();
			if(q.size()==1) {
				break;
			}
			q.offer(q.poll());
		}
		System.out.println(q.poll());
	}

}