import sun.awt.im.CompositionArea;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            char[] s = f.readLine().toCharArray();
            Arrays.sort(s);
            boolean firstKSame = true;
            for(int j = 0; j < k; j++) {
                if(s[0] != s[j]) {
                    firstKSame = false;
                    break;
                }
            }
            if(firstKSame) {
                out.print(s[0]);
                StringBuilder rest = new StringBuilder();
                boolean restSame = true;
                for(int j = k; j < n; j++) {
                    if(s[k] != s[j]) {
                        restSame = false;
                    }
                    rest.append(s[j]);
                }
                if(restSame) {
                    int repeats = (n-k)/k;
                    if(k*repeats < n-k) {
                        repeats++;
                    }
                    for(int j = 0; j < repeats; j++) {
                        out.print(s[k]);
                    }
                    out.println();
                } else {
                    out.println(rest);
                }
            } else {
                out.println(s[k-1]);
            }
        }
        f.close();
        out.close();
    }
}
