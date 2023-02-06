import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        TreeSet<Integer> lights = new TreeSet<>();
        lights.add(0);
        TreeMap<Integer, Integer> lengths = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(st.nextToken());
        lights.add(x);
        lengths.put(x, 1);
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            int low = lights.floor(p);
            int high = lights.ceiling(p);
            lights.add(p);
            int temp = lengths.get(high-low)-1;
            if(temp == 0) {
                lengths.remove(high-low);
            } else {
                lengths.put(high-low, temp);
            }
            lengths.put(p-low, lengths.getOrDefault(p-low, 0)+1);
            lengths.put(high-p, lengths.getOrDefault(high-p, 0)+1);
            out.println(lengths.lastKey());
        }
        f.close();
        out.close();
    }
}