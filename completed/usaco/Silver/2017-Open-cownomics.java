import java.io.*;
import java.util.*;

public class Main {
    private static boolean validThreeDistinctPositions(int[][] spotted, int[][] plain, int p1, int p2, int p3) {
        boolean[][][] set = new boolean[4][4][4];
        for(int[] i: spotted) {
            set[i[p1]][i[p2]][i[p3]] = true;
        }
        for(int[] i: plain) {
            if(set[i[p1]][i[p2]][i[p3]]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("cownomics.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] spotted = new int[N][M];
        for(int i = 0; i < N; i++) {
            char[] temp = f.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                int code;
                if(temp[j] == 'A') {
                    code = 0;
                } else if(temp[j] == 'C') {
                    code = 1;
                } else if(temp[j] == 'G') {
                    code = 2;
                } else {
                    code = 3;
                }
                spotted[i][j] = code;
            }
        }
        int[][] plain = new int[N][M];
        for(int i = 0; i < N; i++) {
            char[] temp = f.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                int code;
                if(temp[j] == 'A') {
                    code = 0;
                } else if(temp[j] == 'C') {
                    code = 1;
                } else if(temp[j] == 'G') {
                    code = 2;
                } else {
                    code = 3;
                }
                plain[i][j] = code;
            }
        }
        int count = 0;
        for(int i = 0; i < M; i++) {
            for(int j = i+1; j < M; j++) {
                for(int k = j+1; k < M; k++) {
                    if(validThreeDistinctPositions(spotted,plain,i,j,k)) {
                        count++;
                    }
                }
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
