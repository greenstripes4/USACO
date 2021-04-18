import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("-1 -1")) {
            StringTokenizer st = new StringTokenizer(input);
            int R = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] x = new int[n];
            for(int i = 0; i < n; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(x);
            int i = 0;
            int j = 0;
            while(j < n && x[j] <= x[i]+R) {
                j++;
            }
            j--;
            i++;
            int c = 1;
            while(i < n) {
                if(x[i] > x[j]+R) {
                    while(j < n && x[j] <= x[i]+R) {
                        j++;
                    }
                    j--;
                    c++;
                }
                i++;
            }
            out.println(c);
        }
        f.close();
        out.close();
    }
}