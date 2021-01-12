import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        long sum = 0;
        long count = 0;
        int last = -1;
        for(int i = 0; i < n; i++) {
            int ai = Integer.parseInt(st.nextToken());
            sum += ai;
            last = Math.max(last, map.getOrDefault(sum, -2)+1);
            count += i-last;
            map.put(sum, i);
        }
        out.println(count);
        f.close();
        out.close();
    }
}