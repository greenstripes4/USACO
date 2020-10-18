import java.io.*;
import java.util.*;

public class Main{
    private static int volume;
    private static int solve(char[] symbols, int index) {
        int i;
        for(i = index+1; i < symbols.length; i++) {
            if(symbols[i] == '\\') {
                i = solve(symbols, i);
            } else if(symbols[i] == '/') {
                volume += i-index;
                break;
            }
        }
        return i;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            char[] symbols = f.readLine().toCharArray();
            volume = 0;
            for(int i = 0; i < symbols.length; i++) {
                if(symbols[i] == '\\') {
                    i = solve(symbols, i);
                }
            }
            out.println(volume);
        }
        f.close();
        out.close();
    }
}
