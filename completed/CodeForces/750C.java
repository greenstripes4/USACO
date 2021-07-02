import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int add = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int change = Integer.parseInt(st.nextToken());
            int div = Integer.parseInt(st.nextToken());
            if(div == 1) {
                min = Math.max(min, 1900-add);
            } else {
                max = Math.min(max, 1899-add);
            }
            add += change;
        }
        if(min > max) {
            out.println("Impossible");
        } else if(max == Integer.MAX_VALUE) {
            out.println("Infinity");
        } else {
            out.println(max+add);
        }
        f.close();
        out.close();
    }
}