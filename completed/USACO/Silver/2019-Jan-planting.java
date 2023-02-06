import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("planting.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
        int N = Integer.parseInt(f.readLine());
        int[] children = new int[N+1];
        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            children[Integer.parseInt(st.nextToken())]++;
            children[Integer.parseInt(st.nextToken())]++;
        }
        int max = 0;
        for(int i: children) {
            max = Math.max(max, i);
        }
        out.println(max+1);
        f.close();
        out.close();
    }
}
