import java.io.*;
import java.util.*;

public class Main {
    private static class Pair {
        private long val;
        private boolean overflow;
        private Pair(long val, boolean overflow) {
            this.val = val;
            this.overflow = overflow;
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int l = Integer.parseInt(f.readLine());
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(1, false));
        long multiplier = 1;
        long x = 0;
        long max = (1L << 32)-1;
        boolean overflow = false;
        boolean valid = true;
        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String command = st.nextToken();
            if(command.equals("add")) {
                if(overflow) {
                    valid = false;
                    break;
                }
                x += multiplier;
                if(x > max) {
                    valid = false;
                    break;
                }
            } else if(command.equals("end")) {
                Pair temp = stack.pop();
                multiplier = temp.val;
                if(!temp.overflow) {
                    overflow = false;
                }
            } else {
                stack.push(new Pair(multiplier, overflow));
                int count = Integer.parseInt(st.nextToken());
                if(!overflow) {
                    multiplier *= count;
                    if(multiplier > max) {
                        overflow = true;
                    }
                }
            }
        }
        out.println(valid ? x : "OVERFLOW!!!");
        f.close();
        out.close();
    }
}