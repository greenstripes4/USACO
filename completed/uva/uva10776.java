import java.io.*;
import java.util.*;

public class Main{
    private static void recur(char[] chars, int ind, int r, StringBuilder sb, PrintWriter out) {
        if(r == 0) {
            out.println(sb);
            return;
        }
        for(int i = ind; i < chars.length; i++) {
            sb.append(chars[i]);
            recur(chars, i+1, r-1, sb, out);
            sb.delete(sb.length()-1,sb.length());
            while(i < chars.length-1 && chars[i] == chars[i+1]) {
                i++;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            char[] chars = st.nextToken().toCharArray();
            Arrays.sort(chars);
            int r = Integer.parseInt(st.nextToken());
            recur(chars, 0, r, new StringBuilder(), out);
        }
        f.close();
        out.close();
    }
}
