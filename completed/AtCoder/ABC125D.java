import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] A = new int[N];
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            sum += Math.abs(A[i]);
            min = Math.min(min, Math.abs(A[i]));
        }
        boolean flag = false;
        for(int i = 0; i < N-1; i++) {
            if(A[i] == 0) {
                flag = true;
                break;
            }
            if(A[i] < 0) {
                A[i+1] = -A[i+1];
            }
        }
        flag |= A[N-1] >= 0;
        out.println(sum-(flag ? 0 : 2L*min));
        f.close();
        out.close();
    }
}
