import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int N = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            Integer[] a = new Integer[N];
            for(int j = 0; j < N; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return integer%2-t1%2;
                }
            });
            out.print(a[0]);
            for(int j = 1; j < N; j++) {
                out.print(" " + a[j]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}