import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int cases = Integer.parseInt(f.readLine());
        for(int t = 0; t < cases; t++) {
            f.readLine();
            if(t > 0) {
                out.println();
            }
            int n = Integer.parseInt(f.readLine());
            int l = Integer.parseInt(f.readLine());
            int[] items = new int[n];
            for(int i = 0; i < n; i++) {
                items[i] = Integer.parseInt(f.readLine());
            }
            Arrays.sort(items);
            int bins = 0;
            int first = 0;
            int last = n-1;
            while(first <= last) {
                bins++;
                if(items[first]+items[last] <= l) {
                    first++;
                }
                last--;
            }
            out.println(bins);
        }
        f.close();
        out.close();
    }
}
