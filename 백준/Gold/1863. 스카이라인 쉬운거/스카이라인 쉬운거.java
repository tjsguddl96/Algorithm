import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static class Building implements Comparable<Building>{
        int x;
        int y;
        public Building(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Building o){
            return this.x-o.x;
        }
    }
    static PriorityQueue<Building> buildings=new PriorityQueue<>();
    static Stack<Integer> stack=new Stack<>();
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(bf.readLine());
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            buildings.add(new Building(x,y));
        }

        while(!buildings.isEmpty()){
            Building now=buildings.poll();
            int nowY=now.y;
//            System.out.println(now.x+" "+now.y);
//            System.out.println(stack);
            while(!stack.isEmpty() && stack.peek()>nowY){
                stack.pop();
                answer++;
            }
            if(nowY==0 || (!stack.isEmpty() && stack.peek()== nowY)){
                continue;
            }
            stack.add(nowY);
            
//            System.out.println(answer);
        }
//        System.out.println(stack);
        answer+=stack.size();
//        System.out.println();
        System.out.println(answer);
    }
}
/*
6
1 1
2 2
4 1
5 2
7 3
11 2
-> 4

8
1 2
2 3
5 4
7 2
11 4
12 2
13 4
15 3
->6 /

6
1 4
7 1
9 0
12 4
14 3
17 2
->5

5
1 4
7 1
12 4
14 3
17 1
-> 4

4
1 4
7 1
12 4
14 3
-> 4

5
1 1
2 0
3 1
4 0
5 3
->3

5
1 1
2 0
3 1
4 0
5 1
->3

4
1 4
2 3
3 5
4 4
->4

7
1 1
2 2
5 3
6 1
7 3
8 2
9 0
->5

11
1 6
3 5
4 6
6 0
8 2
9 3
11 1
12 2
13 1
14 0
15 1
-> 8

5
1 1
3 3
4 2
6 3
7 2
->4

4
1 3
2 2
3 4
4 3
->4

10
1 3
2 2
3 4
10 3
11 1
12 0
4 3
5 2
6 3
7 0
->7

8
1 1
2 2
5 1
6 3
8 1
15 2
17 3
20 2
->5

1
100 100
->1

9
3 1
4 2
5 3
6 2
7 3
8 4
9 2
12 0
->5


13
3 1
4 2
5 3
6 2
7 3
8 4
9 2
12 0
13 1
14 3
15 2
16 3
17 2
->9
* */