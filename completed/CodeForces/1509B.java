import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            char[] arr =  f.readLine().toCharArray();
            int ta = 0;
            for(char j: arr) {
                if(j == 'T') {
                    ta++;
                }
            }
            int tb = 0;
            int m = 0;
            boolean valid = true;
            for(char j: arr) {
                if(j == 'T') {
                    ta--;
                    tb++;
                } else {
                    if((tb-2*m > 0 && ta > 0) || (tb-m > 0 && ta-m > 0)) {
                        m++;
                        continue;
                    }
                    valid = false;
                    break;
                }
            }
            if(tb != 2*m) {
                valid = false;
            }
            out.println(valid ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}