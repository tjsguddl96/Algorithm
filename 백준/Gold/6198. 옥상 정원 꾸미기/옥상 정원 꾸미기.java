import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {

	public static Stack<Integer> stack = new Stack<>();
	public static long ans; // long으로 선언!
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			
			int height = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty()) {
				
				if(stack.peek() <= height) {
					// i번째 빌딩보다 낮거나 같은 애들은 빼버린다.
					stack.pop();
				}
				else break;
			}
			ans += stack.size(); //스택 사이즈를 더함으로써, 벤치마킹 가능한 개수를 더해준다.
			stack.push(height); //i번째 빌딩의 높이를 넣어준다.
		}
		bw.write(String.valueOf(ans));
		bw.close();
	}
}