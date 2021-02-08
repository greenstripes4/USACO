import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        HashMap<Long, Integer> map = new HashMap<>();
        long count = 0;
        long sum = 0;
        st = new StringTokenizer(f.readLine());
        map.put(sum, 1);
        for(int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
            count += map.getOrDefault(sum-x, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        out.println(count);
        f.close();
        out.close();
    }
}