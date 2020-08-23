import java.io.*;
import java.util.*;

public class Main{
    private static int binarySearch(int[] row, int L) {
        int low = 0;
        int high = row.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(row[mid] >= L) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] H = new int[N][M];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(f.readLine());
                for(int j = 0; j < M; j++) {
                    H[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int Q = Integer.parseInt(f.readLine());
            for(int i = 0; i < Q; i++) {
                st = new StringTokenizer(f.readLine());
                int L = Integer.parseInt(st.nextToken());
                int U = Integer.parseInt(st.nextToken());
                int max = 0;
                for(int j = 0; j < N; j++) {
                    int k = binarySearch(H[j],L);
                    if(k < 0) {
                        continue;
                    }
                    for(int l = max; l < Math.min(N-j,M-k); l++) {
                        int rightSide = j+l;
                        int bottomSide = k+l;
                        if(H[rightSide][bottomSide] > U) {
                            break;
                        }
                        max = Math.max(max,l+1);
                    }
                }
                out.println(max);
            }
            out.println("-");
        }
        f.close();
        out.close();
    }
}
