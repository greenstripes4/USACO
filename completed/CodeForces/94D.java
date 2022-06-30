import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        double avg = n*w/(double) m;
        ArrayList<HashMap<Integer, Double>> res = new ArrayList<>(m);
        for(int i = 0; i < m; i++) {
            res.add(new HashMap<>());
        }
        int idx = 0;
        double left = avg;
        boolean valid = true;
        for(int i = 1; i <= n && valid; i++) {
            double vol = w;
            boolean flag = false;
            while(vol > 0.0000001) {
                if(left < vol && !flag || Math.abs(left-vol) <= 0.0000001) {
                    res.get(idx++).put(i, left);
                    vol -= left;
                    left = avg;
                    flag = true;
                } else if(left > vol) {
                    res.get(idx).put(i, vol);
                    left -= vol;
                    vol = 0;
                } else {
                    valid = false;
                    break;
                }
            }
        }
        if(valid) {
            out.println("YES");
            for(HashMap<Integer, Double> map: res) {
                for(int i: map.keySet()) {
                    out.print(i + " " + map.get(i) + " ");
                }
                out.println();
            }
        } else {
            out.println("NO");
        }
        f.close();
        out.close();
    }
}