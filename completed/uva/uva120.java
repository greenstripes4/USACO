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
            int[] stack = new int[st.countTokens()];
            for(int i = 0; i < stack.length; i++) {
                stack[i] = Integer.parseInt(st.nextToken());
            }
            out.println(input);
            int idx = stack.length;
            while(idx > 1) {
                int min = 0;
                for(int i = 1; i < idx; i++) {
                    if(stack[i] < stack[min]) {
                        min = i;
                    }
                }
                out.print(stack.length-min);
                out.print(" ");
                for(int i = 0; i < (min+1)/2; i++) {
                    int temp = stack[i];
                    stack[i] = stack[min-i];
                    stack[min-i] = temp;
                }
                out.print(stack.length-idx+1);
                out.print(" ");
                for(int i = 0; i < idx/2; i++) {
                    int temp = stack[i];
                    stack[i] = stack[idx-i-1];
                    stack[idx-i-1] = temp;
                }
                idx--;
            }
            out.println("1 0");
        }
        f.close();
        out.close();
    }
}
