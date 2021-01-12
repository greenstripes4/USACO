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
        HashMap<Integer, Long> two = new HashMap<>();
        HashMap<Integer, Integer> one = new HashMap<>();
        long count = 0;
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            int ai = Integer.parseInt(st.nextToken());
            if(ai%k == 0) {
                count += two.getOrDefault(ai/k, 0L);;
                two.put(ai, two.getOrDefault(ai, 0L)+one.getOrDefault(ai/k, 0));
            }
            one.put(ai, one.getOrDefault(ai, 0)+1);
        }
        out.println(count);
        f.close();
        out.close();
    }
}