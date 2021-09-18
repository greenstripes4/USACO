import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<String> shortestPath(long u, long v) {
        ArrayList<String> res = new ArrayList<>();
        while(u != v) {
            if(u > v) {
                res.add(u/2 + " " + u);
                u /= 2;
            } else {
                res.add(v/2 + " " + v);
                v /= 2;
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int q = Integer.parseInt(f.readLine());
        HashMap<String, Long> edges = new HashMap<>();
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            if(Integer.parseInt(st.nextToken()) == 1) {
                long u = Long.parseLong(st.nextToken());
                long v = Long.parseLong(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                ArrayList<String> path = shortestPath(u, v);
                for(String i: path) {
                    edges.put(i, edges.getOrDefault(i, 0L)+w);
                }
            } else {
                long u = Long.parseLong(st.nextToken());
                long v = Long.parseLong(st.nextToken());
                ArrayList<String> path = shortestPath(u, v);
                long ans = 0;
                for(String i: path) {
                    ans += edges.getOrDefault(i, 0L);
                }
                out.println(ans);
            }
        }
        f.close();
        out.close();
    }
}