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
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            ArrayList<String> A = new ArrayList<>();
            for(int i = 0; i < M; i++) {
                A.add(f.readLine());
            }
            ArrayList<String> B = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                B.add(f.readLine());
            }
            HashSet<String> C = new HashSet<>();
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    C.add(A.get(i)+B.get(j));
                }
            }
            out.println("Case " + t + ": " + C.size());
        }
        f.close();
        out.close();
    }
}
