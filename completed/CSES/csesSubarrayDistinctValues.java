import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Integer> values = new HashMap<>();
        int i = 0;
        int j = 0;
        long ans = 0;
        while(true) {
            if(values.size() <= k) {
                ans += j-i;
                if(j == n) {
                    break;
                }
                values.put(x[j], values.getOrDefault(x[j], 0)+1);
                j++;
            } else {
                while(values.size() > k) {
                    if(values.get(x[i]) == 1) {
                        values.remove(x[i]);
                    } else {
                        values.put(x[i], values.get(x[i])-1);
                    }
                    i++;
                }
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}