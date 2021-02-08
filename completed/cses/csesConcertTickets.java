import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> h = new TreeMap<>();
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            h.put(temp, h.getOrDefault(temp, 0)+1);
        }
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < m; i++) {
            Integer temp = h.lowerKey(Integer.parseInt(st.nextToken())+1);
            if(temp == null) {
                out.println(-1);
            } else {
                out.println(temp);
                int left = h.get(temp)-1;
                if(left == 0) {
                    h.remove(temp);
                } else {
                    h.put(temp, left);
                }
            }
        }
        f.close();
        out.close();
    }
}