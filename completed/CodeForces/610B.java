import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        long min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, a[i]);
        }
        ArrayList<Integer> pos = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(a[i] == min) {
                pos.add(i);
            }
        }
        int max = pos.get(0)+n-pos.get(pos.size()-1)-1;
        for(int i = 1; i < pos.size(); i++) {
            max = Math.max(max, pos.get(i)-pos.get(i-1)-1);
        }
        out.println(min*n+max);
        f.close();
        out.close();
    }
}
