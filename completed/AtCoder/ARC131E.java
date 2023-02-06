import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer> red;
    private static ArrayList<Integer> blue;
    private static ArrayList<Integer> white;
    private static void construct(int N) {
        if(N == 5) {
            red.add(1);
            red.add(4);
            blue.add(2);
            blue.add(3);
            white.add(5);
            return;
        }
        if(N == 6) {
            red.add(1);
            red.add(6);
            blue.add(2);
            blue.add(5);
            white.add(3);
            white.add(4);
            return;
        }
        if(N == 8) {
            red.add(1);
            red.add(2);
            red.add(3);
            red.add(6);
            blue.add(4);
            blue.add(8);
            white.add(5);
            white.add(7);
            return;
        }
        if(N == 9) {
            red.add(1);
            red.add(2);
            red.add(3);
            red.add(4);
            red.add(5);
            blue.add(6);
            blue.add(9);
            white.add(7);
            white.add(8);
            return;
        }
        red.add(N-5);
        red.add(N);
        blue.add(N-4);
        blue.add(N-1);
        white.add(N-3);
        white.add(N-2);
        construct(N-6);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        if(N < 5 || N%3 == 2) {
            out.println("No");
        } else {
            out.println("Yes");
            red = new ArrayList<>();
            blue = new ArrayList<>();
            white = new ArrayList<>();
            construct(N-1);
            char[][] colors = new char[N][N];
            for(int i: red) {
                for(int j = 0; j < i; j++) {
                    colors[j][i] = 'R';
                }
            }
            for(int i: blue) {
                for(int j = 0; j < i; j++) {
                    colors[j][i] = 'B';
                }
            }
            for(int i: white) {
                for(int j = 0; j < i; j++) {
                    colors[j][i] = 'W';
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    out.print(colors[i][j]);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
