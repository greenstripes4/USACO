import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            Stack<int[]> stack = new Stack<>();
            boolean valid = true;
            while(st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                if(next < 0) {
                    if(!stack.isEmpty()) {
                        int[] prev = stack.pop();
                        prev[1] += -next;
                        stack.push(prev);
                    }
                    stack.push(new int[]{next, 0});
                } else {
                    if(stack.isEmpty() || -stack.peek()[0] != next || stack.peek()[1] >= next) {
                        valid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            valid = valid&stack.isEmpty();
            out.println(valid ? ":-) Matrioshka!" : ":-( Try again.");
        }
        f.close();
        out.close();
    }
}
