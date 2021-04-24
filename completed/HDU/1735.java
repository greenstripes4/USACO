import java.io.*;
import java.util.*;

public class Main {
    private static int trailingZeros(int[] row) {
        for(int i = row.length-1; i >= 0; i--) {
            if(row[i] == 1) {
                return row.length-i-1;
            }
        }
        return row.length;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][L];
            ArrayList<Integer> ends = new ArrayList<>();
            int sum = 0;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(f.readLine());
                for(int j = 0; j < L; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 0) {
                        sum++;
                    }
                }
                if(i > 0 && arr[i][0] == 0 && arr[i][1] == 0) {
                    ends.add(trailingZeros(arr[i-1]));
                }
            }
            sum -= 2*M;
            sum -= trailingZeros(arr[N-1]);
            Collections.sort(ends);
            for(int i = 1; i < M; i++) {
                sum -= ends.get(ends.size()-i);
            }
            out.println(sum);
        }
        f.close();
        out.close();
    }
}