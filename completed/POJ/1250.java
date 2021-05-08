import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int n = f.nextInt();
            if(n == 0) {
                break;
            }
            char[] arr = f.next().toCharArray();
            boolean[] seen = new boolean[26];
            int ans = 0;
            for(char i: arr) {
                i -= 'A';
                if(seen[i]) {
                    seen[i] = false;
                    n++;
                } else if(n == 0) {
                    ans++;
                } else {
                    seen[i] = true;
                    n--;
                }
            }
            out.println(ans/2 == 0 ? "All customers tanned successfully." : ans/2 + " customer(s) walked away.");
        }
        f.close();
        out.close();
    }
}