import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowpatibility.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowpatibility.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] arr = new int[N][5];
        HashMap<String, Integer>[] subsets = new HashMap[6];
        for(int i = 1; i <= 5; i++) {
            subsets[i] = new HashMap<>();
        }
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
            for(int j = 1; j < 32; j++) {
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < 5; k++) {
                    if((j&(1 << k)) > 0) {
                        sb.append(arr[i][k]);
                        sb.append(" ");
                    }
                }
                int x = Integer.bitCount(j);
                String temp = sb.toString();
                subsets[x].put(temp, subsets[x].getOrDefault(temp, 0)+1);
            }
        }
        long ans = 0;
        long sign = 1;
        for(int i = 1; i <= 5; i++) {
            for(int j: subsets[i].values()) {
                ans += sign*j*(j-1)/2;
            }
            sign *= -1;
        }
        out.println((long) N*(N-1)/2-ans);
        f.close();
        out.close();
    }
}
