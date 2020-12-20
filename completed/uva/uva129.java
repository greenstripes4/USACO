import java.io.*;
import java.util.*;

public class Main{
    private static int count;
    private static int n;
    private static int L;
    private static void output(StringBuilder sb, PrintWriter out) {
        char[] arr = sb.toString().toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(i == 64) {
                out.println();
            } else if(i > 0 && i%4 == 0) {
                out.print(" ");
            }
            out.print(arr[i]);
        }
        out.println("\n" + arr.length);
    }
    private static boolean valid(StringBuilder test) {
        for(int i = 1; i <= test.length()/2; i++) {
            if(test.substring(test.length()-2*i, test.length()-i).equals(test.substring(test.length()-i))) {
                return false;
            }
        }
        return true;
    }
    private static boolean solve(StringBuilder sb, PrintWriter out) {
        if(valid(sb)) {
            count++;
            if(count == n) {
                output(sb, out);
                return true;
            }
            for(int i = 0; i < L; i++) {
                char next = (char)('A'+i);
                sb.append(next);
                if(solve(sb, out)) {
                    return true;
                }
                sb.deleteCharAt(sb.length()-1);
            }
            return false;
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            count = -1;
            n = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            solve(new StringBuilder(), out);
        }
        f.close();
        out.close();
    }
}
