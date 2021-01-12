import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] occurances = new int[n];
            for(int i = 0; i < n; i++) {
                occurances[Integer.parseInt(st.nextToken())-1]++;
            }
            int max = 0;
            int count = 0;
            for(int i: occurances) {
                if(i == max) {
                    count++;
                } else if(i > max) {
                    max = i;
                    count = 1;
                }
            }
            out.println((n-count)/(max-1)-1);
        }
        f.close();
        out.close();
    }
}