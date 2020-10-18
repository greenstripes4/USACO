import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] mangoTypes = new int[N];
            int sum = 0;
            for(int i = 0; i < N; i++) {
                mangoTypes[i] = Integer.parseInt(st.nextToken());
                sum += mangoTypes[i];
            }
            st = new StringTokenizer(f.readLine());
            boolean valid = true;
            for(int i = 0; i < N; i++) {
                if(Integer.parseInt(st.nextToken()) < mangoTypes[i]) {
                    valid = false;
                }
            }
            out.println(sum <= L && valid ? "Case " + t + ": Yes" : "Case " + t + ": No");
        }
        f.close();
        out.close();
    }
}
