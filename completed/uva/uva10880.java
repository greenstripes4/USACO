import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        for(int i = 0; i < N; i++){
            int C = f.nextInt();
            int R = f.nextInt();
            if(R == C){
                out.println("Case #" + (i+1) + ": 0");
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            for(int j = 1; j <= (int) Math.sqrt(C-R); j++){
                if((C-R)%j == 0){
                    if(j > R){
                        queue.offer(j);
                    }
                    if((C-R)/j > R && (C-R)/j != j){
                        stack.push((C-R)/j);
                    }
                }
            }
            out.print("Case #" + (i+1) + ":");
            while(!queue.isEmpty()){
                out.print(" " + queue.poll());
            }
            while(!stack.isEmpty()){
                out.print(" " + stack.pop());
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
