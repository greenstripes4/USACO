import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            boolean[][] taken = new boolean[R][C+1];
            int P = Integer.parseInt(f.readLine());
            for(int i = 0; i < P; i++) {
                st = new StringTokenizer(f.readLine());
                String seat = st.nextToken();
                int row = seat.charAt(0)-'A';
                int col = Integer.parseInt(seat.substring(1));
                if(st.nextToken().equals("-")) {
                    col--;
                }
                taken[row][col] = true;
            }
            int Z = Integer.parseInt(f.readLine());
            int[][] group = new int[Z][2];
            for(int i = 0; i < Z; i++) {
                st = new StringTokenizer(f.readLine());
                String seat = st.nextToken();
                int row = seat.charAt(0)-'A';
                int col = Integer.parseInt(seat.substring(1));
                group[i][0] = row;
                group[i][1] = col;
            }
            Arrays.sort(group, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return t1[1]-ints[1];
                }
            });
            boolean valid = true;
            for(int i = 0; i < Z; i++) {
                int row = group[i][0];
                int col = group[i][1];
                if(taken[row][col-1] && taken[row][col]) {
                    valid = false;
                }
                if(taken[row][col]) {
                    taken[row][col-1] = true;
                } else {
                    taken[row][col] = true;
                }
            }
            out.println(valid ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}
