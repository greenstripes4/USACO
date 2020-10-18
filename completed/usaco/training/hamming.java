/*
ID: strongh2
LANG: JAVA
PROG: runround
TASK: runround
 */

import java.io.*;
import java.util.*;

public class hamming {
    private static boolean valid(int x, ArrayList<Integer> set, int D) {
        for(int i: set) {
            if(Integer.bitCount(x^i) < D) {
                return false;
            }
        }
        return true;
    }
    private static void generateMinimumHammingSet(ArrayList<Integer> set, int last, int N, int limit, int D) {
        if(set.size() == N) {
            return;
        }
        for(int i = last; i < limit; i++) {
            if(valid(i,set,D)) {
                set.add(i);
                generateMinimumHammingSet(set,i+1,N,limit,D);
                return;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("runround.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int limit = (int) Math.pow(2,B);
        ArrayList<Integer> set = new ArrayList<>();
        generateMinimumHammingSet(set,0,N,limit,D);
        for(int i = 0; i < N; i++) {
            out.print(set.get(i));
            if(i%10 == 9 || i == N-1) {
                out.println();
            } else {
                out.print(" ");
            }
        }
        out.close();
        f.close();
    }
}
