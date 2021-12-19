import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            ArrayList<Integer> a = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(a);
            for(int i = 1; i <= n/2; i++) {
                out.println(a.get(i) + " " + a.get(0));
            }
        }
        f.close();
        out.close();
    }
}
