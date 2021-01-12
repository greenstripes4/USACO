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
            char[] a = f.readLine().toCharArray();
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0;
            long count = 0;
            for(int i = 0; i < n; i++) {
                sum += Character.getNumericValue(a[i]);
                count += map.getOrDefault(sum-i-1, 0);
                map.put(sum-i-1, map.getOrDefault(sum-i-1, 0)+1);
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}