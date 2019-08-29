import java.io.*;
import java.util.*;
/*
O(n)
6
1 1
1 2
1 3
2 1
2 2
2 3
6
1 1
1 2
1 3
2 3
2 2
2 1
2
1 1
2 2
4
1 2
1 1
2 1
2 2
7
1 2
1 5
1 1
1 3
2 5
1 4
2 4
 */

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            int numCommands = Integer.parseInt(input);
            boolean isQueue = true;
            boolean isPriorityQueue = true;
            boolean isStack = true;
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for(int i = 0; i < numCommands; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                int commandNumber = Integer.parseInt(st.nextToken());
                int element = Integer.parseInt(st.nextToken());
                if(commandNumber == 1){
                    stack.push(element);
                    queue.add(element);
                    priorityQueue.add(element);
                } else {
                    if(stack.isEmpty() || element != stack.pop()){
                        isStack = false;
                    }
                    if(queue.isEmpty() || element != queue.remove()){
                        isQueue = false;
                    }
                    if(priorityQueue.isEmpty() || element != priorityQueue.remove()){
                        isPriorityQueue = false;
                    }
                }
            }
            if((isQueue && isPriorityQueue) || (isStack && isPriorityQueue) || (isStack && isQueue) || (isQueue && isPriorityQueue && isStack)){
                out.println("not sure");
            } else if(isPriorityQueue){
                out.println("priority queue");
            } else if(isQueue){
                out.println("queue");
            }else if(isStack){
                out.println("stack");
            } else {
                out.println("impossible");
            }
        }
        f.close();
        out.close();
    }
}
