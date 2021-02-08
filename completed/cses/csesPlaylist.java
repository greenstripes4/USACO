import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] k = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            k[i] = Integer.parseInt(st.nextToken());
        }
        HashSet<Integer> seen = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < n) {
            if(seen.contains(k[j])) {
                while(k[i] != k[j]) {
                    seen.remove(k[i++]);
                }
                seen.remove(k[i++]);
            }
            seen.add(k[j++]);
            max = Math.max(max, j-i);
        }
        out.println(max);
        f.close();
        out.close();
    }
}