import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        TreeMap<Integer, Integer> b = new TreeMap<>();
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            b.put(temp, b.getOrDefault(temp, 0)+1);
        }
        int[] c = new int[n];
        for(int i = 0; i < n; i++) {
            Integer temp = b.higherKey(n-a[i]-1);
            if(temp == null) {
                temp = b.firstKey();
            }
            c[i] = (a[i]+temp)%n;
            b.put(temp, b.get(temp)-1);
            if(b.get(temp) == 0) {
                b.remove(temp);
            }
        }
        out.print(c[0]);
        for(int i = 1; i < n; i++) {
            out.print(" " + c[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}
