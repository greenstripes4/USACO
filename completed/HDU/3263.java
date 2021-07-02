import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        HashSet<String> seen = new HashSet<String>();
        int[] diff = new int[N];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(f.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            if(A > B) {
                int temp = A;
                A = B;
                B = temp;
            }
            if(seen.contains(A + " " + B)) {
                continue;
            }
            seen.add(A + " " + B);
            diff[A+1]--;
            diff[B]++;
        }
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += diff[i];
            out.println(H+sum);
        }
        f.close();
        out.close();
    }
}