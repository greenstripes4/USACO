import java.io.*;
import java.util.*;

public class Main {
    private static long gcd(long a, long b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] c = new int[n];
        for(int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken())-1;
        }
        ArrayList<Integer> cycles = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                int j = i;
                int length = 0;
                while(!visited[j]) {
                    visited[j] = true;
                    j = c[j];
                    length++;
                }
                if(j != i) {
                    flag = true;
                    break;
                }
                cycles.add(length);
            }
        }
        if(flag) {
            out.println(-1);
        } else {
            long total = 1;
            for(int i: cycles) {
                long gcd = gcd(total, i);
                total *= i;
                total /= gcd;
            }
            out.println(total%2 == 0 ? total/2 : total);
        }
        f.close();
        out.close();
    }
}